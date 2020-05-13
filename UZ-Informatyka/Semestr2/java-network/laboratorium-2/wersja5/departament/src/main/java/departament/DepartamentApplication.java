package departament;

import lombok.extern.java.Log;

import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import departament.model.AppUser;
import departament.model.Departament;
import departament.model.Person;
import departament.repository.PersonRepository;
import departament.service.AppUserService;
import departament.service.IAppUserService;
import departament.repository.AppUserRepository;
import departament.repository.DepartamentRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Optional;


@Log
@SpringBootApplication
public class DepartamentApplication 
{

	public static void main(String[] args) 
	{
		DepartamentApplication.startH2();
		SpringApplication.run(DepartamentApplication.class, args);
	}
	
    public static void startH2() 
    {
        try 
        {
            Server server = Server.createTcpServer("-tcpAllowOthers")
                                  .start();
            log.info("H2 started on URL = " + server.getURL());
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/msaw3", "msaw3", "msaw3");
            log.info("Connection Established: " + conn.getMetaData().getDatabaseProductName() + "/" + conn.getCatalog());
            Service service1 = new Service();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            System.exit(9);
        }
    }
    
    @Bean
    public CommandLineRunner demoPerson(PersonRepository personRepository, AppUserRepository appUserRepository, DepartamentRepository departamentRepository, AppUserService appUserService) {

        return (args) -> {

        	
        		personRepository.save(new Person("Person1"));
        		personRepository.save(new Person("Person2"));
        		personRepository.save(new Person("Person3"));
        		
        		AppUser appUserDemo1 = new AppUser(1, "username1", "password1", "firstname1", "lastname1", "description1", 22, 1);
        		Departament departamentDemo1 = new Departament("departamentname5", 4, "address1", "mainphone1", "mainmail1", "mainwww1", "description1", 4);
        		departamentRepository.save(departamentDemo1);
        		appUserDemo1.setDepartament(departamentDemo1);
        		appUserRepository.save(appUserDemo1);
        		
        		appUserRepository.save(new AppUser(1, "username2", "password2", "firstname2", "lastname2", "description2", 22, 1));
        		Optional<AppUser> appuser1 = appUserRepository.findById(4);
        		AppUser app1 = new AppUser();
        	
        		if(appuser1.isPresent())
        		{
        			app1 = appuser1.get();
        		}
        		departamentRepository.save(new Departament("departamentname1", 4, "address1", "mainphone1", "mainmail1", "mainwww1", "description1", 4));
                // fetch all customers
                log.info("Persons found with findAll():");
                log.info("-------------------------------");
                personRepository.findAll().forEach((e)->log.info(e.toString()));
                log.info("");
                
                // fetch all departamentRepository
                log.info("departamentRepository found with findAll():");
                log.info("-------------------------------");
                departamentRepository.findAll().forEach((e)->log.info(e.toString()));
                log.info("");
                
                // fetch all customers
                log.info("AppUsers found with findAll():");
                log.info("-------------------------------");
                appUserRepository.findAll().forEach((e)->log.info(e.toString()));
                log.info("");
                

                // fetch all customers
                log.info("AppUsers gggg------ findAll():");
                appUserService.findUser1("firstname1").forEach((e)->log.info(e.toString()));;
                log.info("-------------------------------");
                //List<AppUser> app12 = serv.findUser1("firstname1");
                log.info("getOne ------");
                log.info(appUserService.getOne().toString());
                
                // fetch an individual customer by ID
                Optional<Person> person = personRepository.findById(1);
                log.info("Person found with findOne(1L):");
                log.info("--------------------------------");
                log.info(person.toString());
                log.info("");
        };
    }
    

}
