package ai.recruit.testrecruit.mapper;

import ai.recruit.testrecruit.dto.CompanyRequestDto;
import ai.recruit.testrecruit.entities.Company;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring")
public interface CompanyRequestMapper {
    @Mapping(target = "users", ignore = true)
    Company companieDtoToCompany(CompanyRequestDto companyRequestDto);
}
