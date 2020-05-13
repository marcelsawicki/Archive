package departament;

import lombok.extern.java.Log;

import org.h2.tools.Server;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import departament.model.App_User;
import departament.model.Department;
import departament.repository.AppUserRepository;
import departament.repository.DepartmentRepository;
import departament.service.AppUserService;
import departament.service.DepartmentService;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Log
@SpringBootApplication
@Component
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
            Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/msaw", "msaw", "msaw");
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
    		DepartmentRepository departmentRepository, 
    		AppUserService appUserService, 
    		DepartmentService departmentService) {

        return (args) -> {
        	


			Department deployD = new Department("wdrozenia",
					"Kosciuszki 4/5 Wroclaw", "333333333", "wdrozenia@outlook.com",
					"www.wdrozenia.com",
					"deployment everywhere");
			
			Department saleD = new Department("sprzedaz",
					"Stawki 40 Warszawa", "933332222",
					"sprzedaz@sale.com", "sprzedaz-jeden.pl",
					"stratton");
			
			Department hrD = new Department("HR",
					"Ladna 2 Legnica", "12456789", "hr@hr.eu",
					"hr.eu", "human resources");
			
			final LocalDateTime data1 = LocalDateTime.of( 2014, Month.APRIL, 16, 0, 0, 0 );
			final LocalDateTime data2 = LocalDateTime.of( 2020, Month.MARCH, 16, 0, 0, 0 );

			
			App_User ceo = new App_User("boss", "password", "Helena", "Nowak",
					"CEO", 40000L, 5000L,
					java.sql.Date.valueOf(data1.toLocalDate()));
			
			App_User pm = new App_User("project manager",
					"password2", "Zygmunt", "Kowalski", "project manager",
					20000L, 3000L, java.sql.Date.valueOf(data2.toLocalDate()));
			
			App_User admin = new App_User("sytem administrator", "password", "Aleksandra",
					"Janiak", "DevOps", 4000L, 500L,
					java.sql.Date.valueOf(data2.toLocalDate()));
			App_User programmer = new App_User("programmer", "password",
					"Henryk", "Pilecki", "software developer", 21000L,
					3000L, java.sql.Date.valueOf(data1.toLocalDate()));

			
			appUserRepository.save(admin);
			appUserRepository.save(ceo);
			appUserRepository.save(new App_User("programmer2", "password","Henryk1", "Pilecki1", "software developer", 21000L,3000L, java.sql.Date.valueOf(data1.toLocalDate())));
			appUserRepository.save(new App_User("programmer3", "password","Henryk2", "Pilecki2", "software developer", 21000L,3000L, java.sql.Date.valueOf(data1.toLocalDate())));
			appUserRepository.save(new App_User("programmer4", "password","Henryk3", "Pilecki3", "software developer", 21000L,3000L, java.sql.Date.valueOf(data1.toLocalDate())));
			
			appUserRepository.save(ceo);
			appUserRepository.save(programmer);
			appUserRepository.save(pm);
			departmentRepository.save(saleD);
			departmentRepository.save(deployD);
			departmentRepository.save(hrD);
			departmentRepository.save( new Department("test1","Ladna 2 Legnica", "12456789", "hr@hr.eu","hr.eu", "human resources"));
			departmentRepository.save( new Department("test2","Ladna 2 Legnica", "12456789", "hr@hr.eu","hr.eu", "human resources"));
			departmentRepository.save( new Department("test3","Ladna 2 Legnica", "12456789", "hr@hr.eu","hr.eu", "human resources"));
			departmentRepository.save( new Department("test4","Ladna 2 Legnica", "12456789", "hr@hr.eu","hr.eu", "human resources"));
			departmentRepository.save( new Department("test5","Ladna 2 Legnica", "12456789", "hr@hr.eu","hr.eu", "human resources"));
			departmentRepository.save( new Department("test6","Ladna 2 Legnica", "12456789", "hr@hr.eu","hr.eu", "human resources"));
			
    		// DEPARTAMENT
			
			ceo.setDepartment(saleD);
			appUserRepository.save(ceo);
			
			programmer.setDepartment(deployD);
			appUserRepository.save(programmer);
			
			admin.setDepartment(deployD);
			appUserRepository.save(admin);
			//deployD.setManager(ceo);
			//departmentRepository.save(deployD);
			
            // fetch all departamentRepository
            log.info(" Departaments found with departamentRepository.findAll():");
            log.info("-------------------------------");
            departmentRepository.findAll().forEach((e)->log.info(e.toString()));
            log.info("");
            
            // findAllDepartaments
            log.info(" Departaments found with departamentService.findAllDepartaments():");
            log.info("-------------------------------");
            departmentService.findAllDepartments().forEach((e)->log.info(e.toString()));
            log.info("");
            
// DEPARTAMENT
    		
            // fetch all departamentRepository
            log.info(" Departaments found with departamentRepository.findAll():");
            log.info("-------------------------------");
            departmentRepository.findAll().forEach((e)->log.info(e.toString()));
            log.info("");
            
            // findAllDepartaments
            log.info(" Departaments found with departamentService.findAllDepartaments():");
            log.info("-------------------------------");
            departmentService.findAllDepartments().forEach((e)->log.info(e.toString()));
            log.info("");
            
            /*
            // findDepartamentManagedByUser
            log.info(" Departament found with departamentService.findDepartamentManagedByUser():");
            log.info("-------------------------------");
            log.info(departmentService.findDepartmentManagedByUser("Helena", "Nowak").toString());
            log.info("");
            */
            
            // findDepartamentWithMaxNumberOfEmployes
            log.info(" Departament found with departamentService.findDepartamentWithMaxNumberOfEmployes():");
            log.info("-------------------------------");
            log.info(departmentService.findDepartmentWithMaxNumberOfEmployes().toString());
            log.info("");
            
            // findDepartamentWithMaxUsersSalary
            log.info(" Departament found with departamentService.findDepartamentWithMaxUsersSalary():");
            log.info("-------------------------------");
            log.info(departmentService.findDepartmentWithMaxUsersSalary().toString());
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
            appUserService.findUser("Henryk","Abacki").forEach((e)->log.info(e.toString()));
            log.info("");
            
            // findUsersWithPaymentIsHigher
            log.info("AppUsers found with findUsersWithPaymentIsHigher():");      
            log.info("-------------------------------");
            appUserService.findUsersWithPaymentIsHigher(5L).forEach((e)->log.info(e.toString()));
            log.info("");

        };
    }
    
    
    

}
