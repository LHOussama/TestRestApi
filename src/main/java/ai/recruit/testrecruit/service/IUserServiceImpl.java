package ai.recruit.testrecruit.service;

import ai.recruit.testrecruit.dto.UserRequestDto;
import ai.recruit.testrecruit.dto.UserResponseDto;
import ai.recruit.testrecruit.entities.Company;
import ai.recruit.testrecruit.entities.User;
import ai.recruit.testrecruit.exception.BusinessException;
import ai.recruit.testrecruit.exception.NotFoundException;
import ai.recruit.testrecruit.mapper.UserRequestMapper;
import ai.recruit.testrecruit.mapper.UserResponseMapper;
import ai.recruit.testrecruit.repository.CompanyRepository;
import ai.recruit.testrecruit.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class IUserServiceImpl implements IUserService {

    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;
    private final UserResponseMapper userResponseMapper;
    private final UserRequestMapper userRequestMapper;

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        if (userRepository.existsByEmail(userRequestDto.getEmail()))
            throw new BusinessException("Email already exists");

        Company company = companyRepository.findById(userRequestDto.getCompanyId())
                .orElseThrow(() -> new NotFoundException("Company not found with id: " + userRequestDto.getCompanyId()));

        User user = userRequestMapper.userDtotoUser(userRequestDto);
        user.setPassword(BCrypt.hashpw(userRequestDto.getPassword(),BCrypt.gensalt()));
        user.setCompany(company);
        return userResponseMapper.userToUserResponseDto(userRepository.save(user));
    }

    @Override
    public UserResponseDto updateUser(Long id,UserRequestDto userRequestDto) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found with id: " + id));

        if (!existingUser.getEmail().equals(userRequestDto.getEmail()) &&
                userRepository.existsByEmail(userRequestDto.getEmail()))
            throw new BusinessException("Email already exists");

        if (userRequestDto.getCompanyId() != null &&
                !(existingUser.getCompany().getIdCompany() ==(userRequestDto.getCompanyId()))) {
            Company newCompany = companyRepository.findById(userRequestDto.getCompanyId())
                    .orElseThrow(() -> new NotFoundException("Company not found with id: " + userRequestDto.getCompanyId()));
            existingUser.setCompany(newCompany);
        }
        existingUser.setName(userRequestDto.getName());
        existingUser.setEmail(userRequestDto.getEmail());
        existingUser.setPhoneNumber(userRequestDto.getPhoneNumber());
        existingUser.setAddress(userRequestDto.getAddress());
        existingUser.setDateOfBirth(userRequestDto.getDateOfBirth());
        existingUser.setRole(userRequestDto.getRole());

        if (userRequestDto.getPassword() != null && !userRequestDto.getPassword().isEmpty())
            existingUser.setPassword(BCrypt.hashpw(userRequestDto.getPassword(),BCrypt.gensalt()));

        return userResponseMapper.userToUserResponseDto(userRepository.save(existingUser));
    }

    @Override
    public boolean deleteUser(long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found with id: " + id));

        userRepository.delete(user);
        return true;
    }

    @Override
    public UserResponseDto findUser(long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found with id: " + id));

        return userResponseMapper.userToUserResponseDto(user);
    }

    @Override
    public List<UserResponseDto> findAllUsers() {
        return userRepository.findAll().stream()
                .map(userResponseMapper::userToUserResponseDto)
                .toList();
    }
}