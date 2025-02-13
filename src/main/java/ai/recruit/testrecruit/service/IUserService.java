package ai.recruit.testrecruit.service;
import ai.recruit.testrecruit.dto.UserRequestDto;
import ai.recruit.testrecruit.dto.UserResponseDto;
import java.util.List;
public interface IUserService {
    public UserResponseDto createUser(UserRequestDto user );
    public UserResponseDto updateUser(Long id,UserRequestDto user);
    public void deleteUser(long id);
    public UserResponseDto findUser(long id);
    public List<UserResponseDto> findAllUsers();
}
