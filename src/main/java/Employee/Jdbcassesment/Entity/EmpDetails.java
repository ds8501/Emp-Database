package Employee.Jdbcassesment.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Component
public class EmpDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;

    @Column(unique = true)
    private String email;
    private String m_id;
    private String department ;

    private String dob;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="emp_id",referencedColumnName = "id")
    private List<Address> addresses = new ArrayList<>();
}

