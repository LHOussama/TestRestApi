package ai.recruit.testrecruit.mapper;
import ai.recruit.testrecruit.dto.CompanyResponseDto;
import ai.recruit.testrecruit.entities.Company;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring")
public interface CompanyResponseMapper {
    @Mapping(source = "users", target = "users")
    CompanyResponseDto companyToCompanyResponseDto(Company company);

}
