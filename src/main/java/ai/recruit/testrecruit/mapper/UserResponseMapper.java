package ai.recruit.testrecruit.mapper;
import ai.recruit.testrecruit.dto.UserResponseDto;
import ai.recruit.testrecruit.entities.User;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface UserResponseMapper {
    UserResponseDto userToUserResponseDto (User user);

}
