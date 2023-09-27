package Employee.Jdbcassesment.Entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Address {
    @Id
    private String add_Id;
    private int pincode;
    private String city;
    private String country;

    @ManyToOne
    @JoinColumn(name="emp_id")
    private Emp_details empDetails;


    public Address() {
    }

    public Address(String add_Id, int pincode, String city, String country) {
        this.add_Id = add_Id;
        this.pincode = pincode;
        this.city = city;
        this.country = country;

    }

    public void setEmp_id(String add_Id) {
        this.add_Id = add_Id;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "add_Id='" + add_Id + '\'' +
                ", pincode=" + pincode +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", empDetails=" + empDetails +
                '}';
    }
}
