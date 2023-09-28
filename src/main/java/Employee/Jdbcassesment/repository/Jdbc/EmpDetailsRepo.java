package Employee.Jdbcassesment.repository.Jdbc;

import Employee.Jdbcassesment.Entity.EmpDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmpDetailsRepo {
    @Autowired
    private JdbcTemplate template;

    private  String searchQueryEmp= """
            Select * from address full outer join emp_details on emp_details.id=address.emp_id where emp_details.id=1
            """;

    private String insertQueryEmp= """
            insert into emp_details values(?,?,?,?,?,?,?)
            """;

    public List<EmpDetails> selectEmp(){
      return template.query(searchQueryEmp,BeanPropertyRowMapper.newInstance(EmpDetails.class));
    }
    public void insert(EmpDetails empDetails){
         template.update(insertQueryEmp,empDetails.getName(),empDetails.getAge(),empDetails.getEmail(),empDetails.getM_id()
        ,empDetails.getDepartment(),empDetails.getAddresses());
    }
}
