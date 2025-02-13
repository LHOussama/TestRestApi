package ai.recruit.testrecruit.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CompanyResponseDto {
    private Long idCompany;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String website;
    private LocalDate foundedDate;
    private List<UserResponseDto> users=new ArrayList<>();
}
