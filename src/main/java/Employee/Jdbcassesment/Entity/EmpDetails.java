package Employee.Jdbcassesment.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    @OneToMany(mappedBy = "empDetails",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JsonManagedReference
    private List<Address> addresses = new ArrayList<>();


    public void add(Address address){
        if(addresses==null)
            addresses=new ArrayList<>();

        addresses.add(address);
        address.setEmpDetails(this);

    }

   public void delete(Optional<Address> address){
        this.addresses.remove(address);
   }
}

