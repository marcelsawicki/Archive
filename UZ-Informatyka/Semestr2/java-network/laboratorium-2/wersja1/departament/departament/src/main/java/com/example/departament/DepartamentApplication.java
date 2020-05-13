package com.example.departament;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.java.Log;
import org.h2.tools.*;

import java.sql.Connection;
import java.sql.DriverManager;

@Log
@SpringBootApplication
public class DepartamentApplication {

	public static void main(String[] args) {
		
		DepartamentApplication.startH2();
		
		SpringApplication.run(DepartamentApplication.class, args);
	}
	
    public static void startH2() {
        try {
            Server server = Server.createTcpServer("-tcpAllowOthers")
                                  .start();
            log.info("H2 started on URL = " + server.getURL());
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.
                                                   getConnection("jdbc:h2:tcp://localhost/~/msaw1", "msaw1", "msaw1");
            log.info("Connection Established: " + conn.getMetaData()
                                                      .getDatabaseProductName() + "/" + conn.getCatalog());
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(9);
        }
    }

}
