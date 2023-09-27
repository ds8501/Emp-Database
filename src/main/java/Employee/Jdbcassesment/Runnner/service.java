package Employee.Jdbcassesment.Runnner;

import Employee.Jdbcassesment.Entity.Address;
import Employee.Jdbcassesment.Entity.Emp_details;
import Employee.Jdbcassesment.repository.Repo;
import Employee.Jdbcassesment.repository.repoAddress;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class service {

    private Repo repo;
    private repoAddress address;

    public service(repoAddress address,Repo repo) {
        this.address = address;
        this.repo=repo;
    }


    @RequestMapping(value = "/findEmp",method = RequestMethod.GET)
    public List<Emp_details> findAll(){
        return repo.findAll();
    }
    @RequestMapping(value = "/findAdd",method = RequestMethod.GET)
    public List<Address> findAllAdd(){
        return address.findAll();
    }
    @Transactional
    @RequestMapping(value = "/findAddById/{id}",method = RequestMethod.GET)
    public List<Address> findAddById(@PathVariable String id){
        Emp_details emp=repo.findByempId(id);
        if(emp!=null)
        return emp.getAddresses();
        else return null;
    }

    @RequestMapping(value = "/findAddByEmp",method = RequestMethod.GET)
    public List<Address> findAddByID(){
        return null;
    }



    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addEmp(@RequestBody Emp_details empDetails){
        repo.save(empDetails);
        return "Data Added";
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public String deleteEmp(@PathVariable String id){
        repo.deleteById(id);
        return "Data Deleted";
    }
}
