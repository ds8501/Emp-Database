package Employee.Jdbcassesment.repository;

import Employee.Jdbcassesment.Entity.Emp_details;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Repo extends JpaRepository<Emp_details,String> {
   List<Emp_details> findBydepartment(String dept);
   Emp_details findByempId(String empId);

}
