package hr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDateTime;
import java.time.Month;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hr.model.Departament;
import hr.model.Pracownik;
import hr.model.Status;
import hr.model.WniosekUrlopowy;
import hr.repository.DepartamentRepository;
import hr.repository.PracownikRepository;
import hr.repository.WniosekUrlopowyRepository;
import lombok.extern.java.Log;

import org.h2.tools.Server;

@Log
@SpringBootApplication
public class HrApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(HrApplication.class, args);
	}
	
	public static void startH2() 
    {
        try 
        {
            Server server = Server.createTcpServer("-tcpAllowOthers")
                                  .start();
            log.info("H2 started on URL = " + server.getURL());
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/hr1", "hr1", "hr1");
            log.info("Connection Established: " + conn.getMetaData().getDatabaseProductName() + "/" + conn.getCatalog());
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            System.exit(9);
        }
    }
	
	 @Bean
	    public CommandLineRunner demoHr(DepartamentRepository departamentRepository,
	    		PracownikRepository pracownikRepository,
	    		WniosekUrlopowyRepository wniosekUrlopowyRepository) {

	        return (args) -> {
	        	
				final LocalDateTime data1 = LocalDateTime.of( 2014, Month.APRIL, 16, 0, 0, 0 );
				final LocalDateTime data2 = LocalDateTime.of( 2020, Month.MARCH, 16, 0, 0, 0 );
	        	
	        	Departament departament1 = new Departament("Wytwarzanie oprogramowania");
	        	Pracownik pracownik1 = new Pracownik("Henryk", "Sienkiewicz");
	        	Pracownik pracownik2 = new Pracownik("Adam", "Mickiewicz");
	        	Pracownik pracownik3 = new Pracownik("Juliusz", "Slowacki");
	        	Pracownik pracownik4 = new Pracownik("Maria", "Konopnicka");
	        	WniosekUrlopowy wniosekUrlopowy1 = new WniosekUrlopowy("Lato 2020",pracownik1,Status.OCZEKUJE,java.sql.Date.valueOf(data1.toLocalDate()),java.sql.Date.valueOf(data2.toLocalDate()));
	        	
	        	departamentRepository.save(departament1);
	        	departamentRepository.save(new Departament("Kadry"));
	        	departamentRepository.save(new Departament("Ksiegowosc"));
	        	departamentRepository.save(new Departament("Zarzad"));
	        	departamentRepository.save(new Departament("Marketing"));
	        	departamentRepository.save(new Departament("Handlowy"));
	        	
	        	pracownikRepository.save(pracownik1);
	        	pracownikRepository.save(pracownik2);
	        	pracownikRepository.save(pracownik3);
	        	pracownikRepository.save(pracownik4);
	        	pracownikRepository.save(new Pracownik("Halina", "Sienkiewicz"));
	        	pracownikRepository.save(new Pracownik("Stefan", "Sienkiewicz"));
	        	pracownikRepository.save(new Pracownik("Irena", "Sienkiewicz"));
	        	pracownikRepository.save(new Pracownik("Antoni", "Sienkiewicz"));
	        	pracownikRepository.save(new Pracownik("Bernadeta", "Sienkiewicz"));
	        	
	        	wniosekUrlopowyRepository.save(wniosekUrlopowy1);
	        	wniosekUrlopowyRepository.save(new WniosekUrlopowy("Zima 2020",pracownik4,Status.OCZEKUJE,java.sql.Date.valueOf(data1.toLocalDate()),java.sql.Date.valueOf(data2.toLocalDate())));
	        	wniosekUrlopowyRepository.save(new WniosekUrlopowy("Jesien 2020",pracownik2,Status.OCZEKUJE,java.sql.Date.valueOf(data1.toLocalDate()),java.sql.Date.valueOf(data2.toLocalDate())));
	        	wniosekUrlopowyRepository.save(new WniosekUrlopowy("Safari 2020",pracownik3,Status.OCZEKUJE,java.sql.Date.valueOf(data1.toLocalDate()),java.sql.Date.valueOf(data2.toLocalDate())));
	        	wniosekUrlopowyRepository.save(new WniosekUrlopowy("Afryka 2020",pracownik4,Status.OCZEKUJE,java.sql.Date.valueOf(data1.toLocalDate()),java.sql.Date.valueOf(data2.toLocalDate())));
	        	wniosekUrlopowyRepository.save(new WniosekUrlopowy("Rzym 2020",pracownik2,Status.OCZEKUJE,java.sql.Date.valueOf(data1.toLocalDate()),java.sql.Date.valueOf(data2.toLocalDate())));
	        	wniosekUrlopowyRepository.save(new WniosekUrlopowy("Madagaskar 2020",pracownik3,Status.OCZEKUJE,java.sql.Date.valueOf(data1.toLocalDate()),java.sql.Date.valueOf(data2.toLocalDate())));
	        	
	            // fetch all departamentRepository
	            log.info(" Departament found with departamentRepository.findAll():");
	            log.info("-------------------------------");
	            departamentRepository.findAll().forEach((e)->log.info(e.toString()));
	            log.info("");
	        	
	            // fetch all pracownikRepository
	            log.info(" Pracownik found with pracownikRepository.findAll():");
	            log.info("-------------------------------");
	            pracownikRepository.findAll().forEach((e)->log.info(e.toString()));
	            log.info("");
	            
	            // fetch all wniosekUrlopowyRepository
	            log.info(" Pracownik found with wniosekUrlopowyRepository.findAll():");
	            log.info("-------------------------------");
	            wniosekUrlopowyRepository.findAll().forEach((e)->log.info(e.toString()));
	            log.info("");
	        	
	        };
	 };

}
