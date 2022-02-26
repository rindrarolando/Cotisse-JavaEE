package com.rindra.hopital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

import com.rindra.hopital.connexion.Rescue;

import java.sql.Connection;


@SpringBootApplication
public class ProjetHopitalApplication {


	public static void main(String[] args) throws SQLException, Exception {
		SpringApplication.run(ProjetHopitalApplication.class, args);


			Connection c = Rescue.connectToDatabase();
			if (c != null) {
				System.out.println("METY");
			}

	}
}
