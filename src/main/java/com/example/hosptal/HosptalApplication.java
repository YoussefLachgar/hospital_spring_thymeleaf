package com.example.hosptal;

import com.example.hosptal.entities.Patient;
import com.example.hosptal.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class HosptalApplication implements CommandLineRunner {

	@Autowired
	private PatientRepository patientRepository;

	public static void main(String[] args) {
		SpringApplication.run(HosptalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// en utilise la methode Builder qui a dans le fichier Patient du package entities
		// Patient patient = Patient.builder().nom("Mouaad").dateNaissance(new Date()).score(1).malad(true).build();
//		patientRepository.save(new Patient(null,"mouaad",new Date(),false,55));
//		patientRepository.save(new Patient(null,"othman",new Date(),true,45));
//		patientRepository.save(new Patient(null,"aimaad",new Date(),false,35));
//		patientRepository.save(new Patient(null,"achraf",new Date(),true,25));

	}
}
