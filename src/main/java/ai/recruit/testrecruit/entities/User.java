package ai.recruit.testrecruit.entities;
import ai.recruit.testrecruit.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long  id;
    private String  name;
    private String  email;
    private String  password;
    private String phoneNumber;
    private String address;
    private LocalDate dateOfBirth;
    @Enumerated(EnumType.STRING)
    private Role role;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

}
