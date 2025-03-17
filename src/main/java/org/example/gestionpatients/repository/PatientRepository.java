package org.example.gestionpatients.repository;

import org.example.gestionpatients.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
