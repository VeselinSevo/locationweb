package com.project.locationweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.*;


@SpringBootApplication
public class LocationwebApplication {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(LocationwebApplication.class, args);
		GetAllTables gat = new GetAllTables();
		gat.printAllTablesFromDatabase();
	}		//C:\Users\Veselin\Desktop\code for my version
}


