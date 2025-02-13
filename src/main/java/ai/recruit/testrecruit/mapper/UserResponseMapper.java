package ai.recruit.testrecruit.mapper;
import ai.recruit.testrecruit.dto.UserResponseDto;
import ai.recruit.testrecruit.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring")
public interface UserResponseMapper {
    @Mapping(source = "company.idCompany",target = "companyId")
    UserResponseDto userToUserResponseDto (User user);

}
