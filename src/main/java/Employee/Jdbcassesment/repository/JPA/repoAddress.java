package Employee.Jdbcassesment.repository.JPA;

import Employee.Jdbcassesment.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface repoAddress extends JpaRepository<Address,Long> {

}
