package ai.recruit.testrecruit.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyRequestDto {
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String website;
    private LocalDate foundedDate;
}
