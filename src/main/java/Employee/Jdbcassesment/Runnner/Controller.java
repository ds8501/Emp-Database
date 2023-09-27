package Employee.Jdbcassesment.Runnner;

import Employee.Jdbcassesment.Entity.Address;
import Employee.Jdbcassesment.Entity.EmpDetails;
import Employee.Jdbcassesment.repository.JPA.Repo;
import Employee.Jdbcassesment.repository.JPA.repoAddress;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

    @Autowired
    private Repo repo;
    @Autowired
    private repoAddress repoAddress;

    @RequestMapping(value = "/employee",method = RequestMethod.POST)
    public String addEmp(@RequestBody EmpDetails empDetails){
        String email=empDetails.getEmail();
        if(!email.contains("@jungleegames.com"))
            return "Enter correct email";
        List<Address> a=empDetails.getAddresses();
        for(Address addr:a){
            repoAddress.save(addr);
        }
        repo.save(empDetails);

        return "Data Added";
    }

    @RequestMapping(value = "/employee/{id}/address",method = RequestMethod.POST)
    public String addAddress(@PathVariable Long id,@RequestBody Address address){
          EmpDetails empDetails=repo.findEmpById(id);
          System.out.println(empDetails.getAddresses());

          empDetails.getAddresses().add(address);
          repoAddress.save(address);

          return "data";
    }

    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    public List<EmpDetails> findAll(){
        return repo.findAll();
    }

    @Transactional
    @RequestMapping(value = "/employee/{id}/address",method = RequestMethod.GET)
    public List<Address> findAddById(@PathVariable Long id){
        Optional<EmpDetails> empDetails=repo.findById(id);
       return empDetails.get().getAddresses();
    }

    @RequestMapping(value = "/employee/{id}",method = RequestMethod.DELETE)
    public String deleteEmp(@PathVariable Long id){
        repo.deleteById(id);
        return "Data Deleted";
    }
}

