package departament;

import lombok.extern.java.Log;

import org.h2.tools.Server;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import departament.model.AppUser;
import departament.model.Departament;
import departament.service.AppUserService;
import departament.service.DepartamentService;
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
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            System.exit(9);
        }
    }
    
    @Bean
    public CommandLineRunner demoPerson(AppUserRepository appUserRepository, 
    		DepartamentRepository departamentRepository, 
    		AppUserService appUserService, 
    		DepartamentService departamentService) {

        return (args) -> {

        		// make AppUsers and Departaments
        		AppUser user1 = new AppUser(1, "username1", "password1", "firstname1", "lastname1", "description1", 22, 1);
        		Departament departament1 = new Departament("departamentname1", 4, "address1", "mainphone1", "mainmail1", "mainwww1", "description1", 4);
        		departamentRepository.save(departament1);
        		user1.setDepartament(departament1);
        		appUserRepository.save(user1);
        		
        		AppUser user2 = new AppUser(1, "username2", "password2", "henryk", "abacki", "description2", 22, 1);
        		Departament departament2 = new Departament("departamentname2", 4, "address1", "mainphone1", "mainmail1", "mainwww1", "description1", 4);
        		departamentRepository.save(departament2);
        		user2.setDepartament(departament2);
        		appUserRepository.save(user2);
        		
        		AppUser user3 = new AppUser(1, "username3", "password3", "leszek", "babacki", "description3", 4, 1);
        		user3.setDepartament(departament2);
        		appUserRepository.save(user3);
                
        		// use service to gain data
        		
        		// DEPARTAMENT
        		
                // fetch all departamentRepository
                log.info(" Departaments found with departamentRepository.findAll():");
                log.info("-------------------------------");
                departamentRepository.findAll().forEach((e)->log.info(e.toString()));
                log.info("");
                
                // findAllDepartaments
                log.info(" Departaments found with departamentService.findAllDepartaments():");
                log.info("-------------------------------");
                departamentService.findAllDepartaments().forEach((e)->log.info(e.toString()));
                log.info("");
                
                // findDepartamentManagedByUser
                log.info(" Departament found with departamentService.findDepartamentManagedByUser():");
                log.info("-------------------------------");
                // log.info(departamentService.findDepartamentManagedByUser("firstname1", "lastname1").toString());
                log.info("");
                
                // findDepartamentWithMaxNumberOfEmployes
                log.info(" Departament found with departamentService.findDepartamentWithMaxNumberOfEmployes():");
                log.info("-------------------------------");
                // log.info(departamentService.findDepartamentWithMaxNumberOfEmployes().toString());
                log.info("");
                
                // findDepartamentWithMaxUsersSalary
                log.info(" Departament found with departamentService.findDepartamentWithMaxUsersSalary():");
                log.info("-------------------------------");
                // log.info(departamentService.findDepartamentWithMaxUsersSalary().toString());
                log.info("");
                
                
        		// APPUSER               
                
                // fetch all appusers
                log.info("AppUsers found with findAll():");
                log.info("-------------------------------");
                appUserRepository.findAll().forEach((e)->log.info(e.toString()));
                log.info("");
                

                // findAllUsers
                log.info("AppUsers found with findAllUsers():");
                log.info("-------------------------------");
                appUserService.findAllUsers().forEach((e)->log.info(e.toString()));
                log.info("");
                
                // findUser
                log.info("AppUser found with findUser():");      
                log.info("-------------------------------");
                appUserService.findUser("firstname1","lastname1").forEach((e)->log.info(e.toString()));
                log.info("");
                
                // findUsersFromDepartament
                log.info("AppUsers found with findUsersFromDepartament():");      
                log.info("-------------------------------");
                // appUserService.findUsersFromDepartament("departament1").forEach((e)->log.info(e.toString()));
                log.info("");
                
                // findUsersWithPaymentIsHigher
                log.info("AppUsers found with findUsersWithPaymentIsHigher():");      
                log.info("-------------------------------");
                appUserService.findUsersWithPaymentIsHigher(5).forEach((e)->log.info(e.toString()));
                log.info("");
                
        };
    }
    

}
