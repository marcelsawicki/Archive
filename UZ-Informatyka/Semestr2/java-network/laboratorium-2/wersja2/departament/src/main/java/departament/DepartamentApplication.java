package departament;

import lombok.extern.java.Log;

import org.h2.tools.Server;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import departament.model.Person;
import departament.repository.PersonRepository;

import java.sql.Connection;
import java.sql.DriverManager;
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
            Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/msaw2", "msaw2", "msaw2");
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
    public CommandLineRunner demoPerson(PersonRepository personRepository) {
        return (args) -> {
        		personRepository.save(new Person("Person1"));
        		personRepository.save(new Person("Person2"));
        		personRepository.save(new Person("Person3"));
        		
                // fetch all customers
                log.info("Persons found with findAll():");
                log.info("-------------------------------");
                personRepository.findAll().forEach((e)->log.info(e.toString()));
                log.info("");
                
                // fetch an individual customer by ID
                Optional<Person> person = personRepository.findById(1);
                log.info("Person found with findOne(1L):");
                log.info("--------------------------------");
                log.info(person.toString());
                log.info("");
        };
    }
    

}
