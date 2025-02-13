package ai.recruit.testrecruit.repository;
import ai.recruit.testrecruit.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    boolean existsByName(String name);

    boolean existsByEmail(String email);

    boolean existsByNameAndIdCompanyNot(String name, Long id);

    boolean existsByEmailAndIdCompanyNot(String email, Long id);
}
