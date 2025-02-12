package ai.recruit.testrecruit.entities;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "COMPANIES")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCompany;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String website;
    private LocalDate foundedDate;
    @OneToMany(mappedBy = "company",cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<User> users=new ArrayList<>();

}
