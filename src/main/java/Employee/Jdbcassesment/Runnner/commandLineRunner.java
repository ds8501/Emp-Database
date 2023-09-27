package Employee.Jdbcassesment.Runnner;

import Employee.Jdbcassesment.Entity.Address;
import Employee.Jdbcassesment.Entity.Emp_details;
import Employee.Jdbcassesment.repository.Repo;
import Employee.Jdbcassesment.repository.repoAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class commandLineRunner implements org.springframework.boot.CommandLineRunner {
    private Logger logger=  LoggerFactory.getLogger(getClass());

    private Repo repo;
    private repoAddress address;

    public commandLineRunner(repoAddress address,Repo repo) {
        this.address = address;
        this.repo=repo;
    }


    @Override
    public void run(String... args) throws Exception {

        List<Address> addresses = new ArrayList<Address>();

        addresses.add(address.save(new Address("JG-1",567,"Banglore","India")));
       // addresses.add(address.save(new Address("JG-1",1234,"Lucknow","India")));
        Emp_details e=repo.save(new Emp_details("JG-1","divya",19,"divya@","Jg-2","It", "11/12/2003",addresses));

        List<Emp_details> users=repo.findBydepartment("It");
        users.forEach(user->logger.info(user.toString()));
    }
}
