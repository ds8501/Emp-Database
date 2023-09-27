package Employee.Jdbcassesment.repository.JPA;

import Employee.Jdbcassesment.Entity.EmpDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo extends JpaRepository<EmpDetails,Long> {
    EmpDetails findEmpById(Long id);

}
