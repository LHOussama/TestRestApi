package ai.recruit.testrecruit.service;

import ai.recruit.testrecruit.dto.CompanyRequestDto;
import ai.recruit.testrecruit.dto.CompanyResponseDto;
import java.util.List;

public interface ICompanyService {
    CompanyResponseDto createCompany(CompanyRequestDto companyRequestDto);
    CompanyResponseDto updateCompany(Long id, CompanyRequestDto companyRequestDto);
    CompanyResponseDto deleteCompany(long id);
    CompanyResponseDto findCompanyById(long id);
    List<CompanyResponseDto> findAllCompanies();
}
