package Employee.Jdbcassesment.Runnner;

import Employee.Jdbcassesment.Entity.Address;
import Employee.Jdbcassesment.Entity.EmpDetails;
import Employee.Jdbcassesment.repository.JPA.RepoEmp;
import Employee.Jdbcassesment.repository.JPA.repoAddress;
import Employee.Jdbcassesment.repository.Jdbc.EmpDetailsJdbcRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

    @Autowired
    private RepoEmp repoEmp;
    @Autowired
    private repoAddress repoAddress;
    @Autowired
    EmpDetailsJdbcRepo empDetailsJdbcRepo;


    //post

    @RequestMapping(value = "/employee",method = RequestMethod.POST)
    public String addEmp(@RequestBody EmpDetails empDetails){
        String email=empDetails.getEmail();
        if(!email.contains("@jungleegames.com"))
            return "Enter correct email";

//        List<Address> a=empDetails.getAddresses();
//        for(Address addr:a){
//            repoAddress.save(addr);
//        }
        empDetailsJdbcRepo.insert(empDetails);

        return "Data Added";
    }

    @RequestMapping(value = "/employee/{id}/address",method = RequestMethod.POST)
    public String addAddress(@PathVariable Long id,@RequestBody Address address){
//          EmpDetails e= repo.findEmpById(id);
//        System.out.println(e.getAddresses().add(address));
//          repoAddress.save(address);
          EmpDetails empDetails = repoEmp.findEmpById(id);
          empDetails.add(address);
          repoEmp.save(empDetails);
          repoAddress.save(address);

          return "data added";
    }


    //get

    @RequestMapping(value = "/employee/{id}",method = RequestMethod.GET)
    public EmpDetails findAll(@PathVariable Long id){
        return empDetailsJdbcRepo.selectEmp(id);
          //   return  repo.findAll();
    }
    @Transactional
    @RequestMapping(value = "/employee/{id}/address",method = RequestMethod.GET)
    public List<Address> findAddById(@PathVariable Long id){
        Optional<EmpDetails> empDetails= repoEmp.findById(id);
       return empDetails.get().getAddresses();
    }

//    @RequestMapping(value = "/employee/{id}",method = RequestMethod.GET)
//    public EmpDetails findEmpById(@PathVariable Long id){
//       return  repo.findEmpById(id);
//    }





    //Delete

    @RequestMapping(value = "/employee/{id}",method = RequestMethod.DELETE)
    public String deleteEmp(@PathVariable Long id){
        repoEmp.deleteById(id);
        return "Data Deleted";
    }

    @RequestMapping(value = "/employee/{id}/address/{aid}",method = RequestMethod.DELETE)
    public String deleteAdd(@PathVariable Long id,@PathVariable long aid){
        EmpDetails empDetails= repoEmp.findEmpById(id);
        Optional<Address> address=repoAddress.findById(id);
        System.out.println(address);
        empDetails.delete(address);
        repoEmp.save(empDetails);

        repoAddress.deleteById(aid);
        return "Data Deleted";
    }
}

