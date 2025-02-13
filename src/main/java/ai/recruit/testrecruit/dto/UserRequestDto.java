package ai.recruit.testrecruit.dto;

import ai.recruit.testrecruit.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {
    private String name;
    private String email;
    private String phoneNumber;
    private String password;
    private String address;
    private LocalDate dateOfBirth;
    private Role role;
    private Long companyId;
}
