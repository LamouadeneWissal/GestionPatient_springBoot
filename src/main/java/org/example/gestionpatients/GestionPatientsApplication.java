package org.example.gestionpatients;

import org.example.gestionpatients.entities.Patient;
import org.example.gestionpatients.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class GestionPatientsApplication implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRepository;
    public static void main(String[] args) {
        SpringApplication.run(GestionPatientsApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        patientRepository.save(new Patient(null, "ahmed" , new Date() , false , 24));
        patientRepository.save(new Patient(null, "Asmae" , new Date() , true , 16));
        patientRepository.save(new Patient(null, "Wissal" , new Date() , false , 22));


    }


}
