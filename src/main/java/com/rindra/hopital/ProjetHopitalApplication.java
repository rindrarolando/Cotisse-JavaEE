package com.rindra.hopital;

import com.rindra.hopital.models.Patient;
import com.rindra.hopital.requete.Requete;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class ProjetHopitalApplication {

	public static void main(String[] args) throws SQLException, Exception{
		SpringApplication.run(ProjetHopitalApplication.class, args);
		Patient p = new Patient("trop","2000-01-01",2,"Gueri","2000-01-20");
		Requete r = new Requete();
		r.InsererPatient(p);
		System.out.println("test");
	}

}
