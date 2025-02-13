package ai.recruit.testrecruit.dto;
import ai.recruit.testrecruit.enums.Role;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    private long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate dateOfBirth;
    private Role role;
    private Long companyId;
}
