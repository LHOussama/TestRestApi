package ai.recruit.testrecruit.service;
import ai.recruit.testrecruit.dto.CompanyRequestDto;
import ai.recruit.testrecruit.dto.CompanyResponseDto;
import ai.recruit.testrecruit.entities.Company;
import ai.recruit.testrecruit.exception.BusinessException;
import ai.recruit.testrecruit.exception.NotFoundException;
import ai.recruit.testrecruit.mapper.CompanyRequestMapper;
import ai.recruit.testrecruit.mapper.CompanyResponseMapper;
import ai.recruit.testrecruit.repository.CompanyRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
 @Service
 @AllArgsConstructor
 @Transactional
 public class ICompanyServiceImpl implements ICompanyService {
     private CompanyRepository companyRepository;
     private CompanyResponseMapper companyResponseMapper;
     private CompanyRequestMapper companyRequestMapper;

     @Override
     public CompanyResponseDto createCompany(CompanyRequestDto companyRequestDto) {
         if(companyRepository.existsByName(companyRequestDto.getName()))
             throw new BusinessException("Name already exists");
         if(companyRepository.existsByEmail(companyRequestDto.getEmail()))
             throw new BusinessException("Mail already exists");

         return companyResponseMapper.companyToCompanyResponseDto(
                 companyRepository.save(companyRequestMapper.companieDtoToCompany(companyRequestDto))
         );
     }

     @Override
     public CompanyResponseDto updateCompany(Long id, CompanyRequestDto companyRequestDto) {
         Company company = companyRepository.findById(id)
                 .orElseThrow(() -> new NotFoundException("Company not found with id: " + id));
         if (companyRepository.existsByNameAndIdCompanyNot(companyRequestDto.getName(), id))
             throw new BusinessException("Company name already exists");

         if (companyRepository.existsByEmailAndIdCompanyNot(companyRequestDto.getEmail(), id))
             throw new BusinessException("Company email already exists");

         company.setName(companyRequestDto.getName());
         company.setEmail(companyRequestDto.getEmail());
         company.setPhoneNumber(companyRequestDto.getPhoneNumber());
         company.setAddress(companyRequestDto.getAddress());
         company.setWebsite(companyRequestDto.getWebsite());
         company.setFoundedDate(companyRequestDto.getFoundedDate());
         return companyResponseMapper.companyToCompanyResponseDto(companyRepository.save(company));
     }

     @Override
     public CompanyResponseDto deleteCompany(long id) {
         Company company = companyRepository.findById(id)
                 .orElseThrow(() -> new NotFoundException("Company not found with id: " + id));

         if (!company.getUsers().isEmpty()) {
             throw new BusinessException("Cannot delete company with associated users");
         }

         CompanyResponseDto responseDto = companyResponseMapper.companyToCompanyResponseDto(company);
         companyRepository.delete(company);
         return responseDto;
     }

     @Override
     public CompanyResponseDto findCompanyById(long id) {
         Company company = companyRepository.findById(id)
                 .orElseThrow(() -> new NotFoundException("Company not found with id: " + id));

         return companyResponseMapper.companyToCompanyResponseDto(company);
     }

     @Override
     public List<CompanyResponseDto> findAllCompanies() {
         List<Company> companies = companyRepository.findAll();
         return companies.stream()
                 .map(companyResponseMapper::companyToCompanyResponseDto)
                 .toList();
     }
 }