package ai.recruit.testrecruit.dto;
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
public class CompanyRequestDto {
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String website;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate foundedDate;
}
