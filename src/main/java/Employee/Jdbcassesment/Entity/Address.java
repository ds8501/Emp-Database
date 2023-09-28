package Employee.Jdbcassesment.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int pincode;
    private String city;
    private String country;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="emp_id")
    @JsonBackReference
    private EmpDetails empDetails;

    public Address( int pincode, String city, String country) {
        this.pincode = pincode;
        this.city = city;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", pincode=" + pincode +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
