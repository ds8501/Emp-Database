package Employee.Jdbcassesment.Entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Table(name="Emp_details")
public class Emp_details {
    @Id
    private String empId;
    private String name;
    private int age;
    private String email;
    private String m_id;
    private String department ;

    private String dob;

    @Getter
    @OneToMany
    private List<Address> addresses;

    public Emp_details(String empId, String name, int age, String email, String m_id, String department, String dob,List<Address>addresses) {
        this.empId = empId;
        this.name = name;
        this.age = age;
        this.email = email;
        this.m_id = m_id;
        this.department = department;
        this.dob = dob;
        this.addresses=addresses;

    }

    public Emp_details() {
    }

    public String getId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getM_id() {
        return m_id;
    }

    public String getDepartment() {
        return department;
    }

    public String getDob() {
        return dob;
    }


    @Override
    public String toString() {
        return "Emp_details{" +
                "id='" + empId + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", m_id='" + m_id + '\'' +
                ", department='" + department + '\'' +
                ", dob='" + dob + '\'' +
                '}';
    }
}

