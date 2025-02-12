package ai.recruit.testrecruit;
import ai.recruit.testrecruit.entities.Company;
import ai.recruit.testrecruit.entities.User;
import ai.recruit.testrecruit.enums.Role;
import ai.recruit.testrecruit.repository.CompanyRepository;
import ai.recruit.testrecruit.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.mapstruct.control.MappingControl;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.time.LocalDate;
import java.util.List;
@SpringBootApplication
@Transactional
public class TestRecruitApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestRecruitApplication.class, args);
    }

    @Bean
    public CommandLineRunner start(CompanyRepository companyRepository, UserRepository userRepository) {
        return args -> {
            //add companies
            List.of("META","BCG").forEach(  name -> {
                 Company company = Company.builder().name(name).
                email(name+"@gmail.com").
                        foundedDate(LocalDate.of(2001,11,12)).
                        phoneNumber("0606060606").
                        address("casablanca").
                        website("www."+name+"com").
                build();
                companyRepository.save(company);
            });
            //add users
            List.of("oussama","yassine").forEach(name -> {
                Company company=companyRepository.findById(1L).orElse(null);
                User user=User.builder()
                        .name(name)
                        .company(company).
                        phoneNumber("0606060606").
                        address("casablanca").
                        role(Role.CEO).
                        email(name+"@gmail.com").
                        password(BCrypt.hashpw(name,BCrypt.gensalt())).
                        dateOfBirth(LocalDate.now())
                        .build();
                userRepository.save(user);
            });
            //get company
            System.out.println("--------------");
            Company company=companyRepository.findById(2L).orElse(null);
            System.out.println(company);
            //get user
            System.out.println("--------------");
            User user=userRepository.findById(2L).orElse(null);
            System.out.println(user);
            //delete company
            System.out.println("--------------");
            assert company != null;
            companyRepository.delete(company);
            companyRepository.findAll().forEach(System.out::println);
            //delete user
            System.out.println("--------------");
            assert user != null;
            userRepository.delete(user);
            userRepository.findAll().forEach(System.out::println);
            //update company
            System.out.println("--------------");
            Company company1=companyRepository.findById(1L).orElse(null);
            assert company1 != null;
            company1.setName("AMAZON");
            companyRepository.save(company1);
            companyRepository.findAll().forEach(System.out::println);
            //update user
            System.out.println("--------------");
            User user1 = userRepository.findById(1L).orElse(null);
            assert user1 != null;
            user1.setName("mustapha");
            userRepository.save(user1);
            userRepository.findAll().forEach(System.out::println);

        };
    }



}
