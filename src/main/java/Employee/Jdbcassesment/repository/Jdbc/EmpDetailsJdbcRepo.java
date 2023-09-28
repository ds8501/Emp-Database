package Employee.Jdbcassesment.repository.Jdbc;

import Employee.Jdbcassesment.Entity.EmpDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

@Repository
public class EmpDetailsJdbcRepo {
    @Autowired
    private NamedParameterJdbcTemplate template;

    private  String searchQueryEmp= """
                    select * from emp_details where emp_details.id=:id
            """;

    private String insertQueryEmp= """
            insert into emp_details(name,age,email,m_id,department,dob,address) values(:name,:age,:email,:m_id,:department,:dob,:address)
            """;

    public EmpDetails selectEmp(Long id){
        HashMap<String ,Long> map=new HashMap<>();
        map.put("id",id);
        return (EmpDetails) template.queryForObject(searchQueryEmp,map,new UserMapper());
    }

    public void insert(final EmpDetails empDetails){
          KeyHolder holder = new GeneratedKeyHolder();
          SqlParameterSource sqlParameterSource=new MapSqlParameterSource()
                  .addValue("name",empDetails.getName())
                  .addValue("age",empDetails.getAge())
                  .addValue("email",empDetails.getEmail())
                  .addValue("m_id",empDetails.getM_id())
                  .addValue("department",empDetails.getDepartment())
                  .addValue("dob",empDetails.getDob())
                  .addValue("address",empDetails.getAddresses());
          template.update(insertQueryEmp, sqlParameterSource,holder);
    }

}

class UserMapper implements RowMapper{

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        EmpDetails empDetails=new EmpDetails();
        empDetails.setName(rs.getString("name"));
        empDetails.setAge(rs.getInt("age"));
        empDetails.setEmail(rs.getString("email"));
        empDetails.setDepartment(rs.getString("department"));
        empDetails.setM_id(rs.getString("m_id"));
        empDetails.setDob(rs.getString("dob"));

        return empDetails;
    }
}
