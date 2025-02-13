package ai.recruit.testrecruit.mapper;
import ai.recruit.testrecruit.dto.UserRequestDto;
import ai.recruit.testrecruit.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring")
public interface UserRequestMapper {
    @Mapping(source = "companyId",target = "company.idCompany")
    User userDtotoUser(UserRequestDto userRequestDto);

}
