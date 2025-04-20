package org.example.gestionpatients.repository;

import org.example.gestionpatients.entities.Patient;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface PatientRepository extends JpaRepository<Patient, Integer> {
    Page<Patient> findByNameContains(String keyword, Pageable pageable);

    @Query("SELECT p FROM Patient p WHERE p.name LIKE %:x%")
    Page<Patient> chercher(@Param("x") String keyword, Pageable pageable);

}
