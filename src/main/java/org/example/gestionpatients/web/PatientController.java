package org.example.gestionpatients.web;

import lombok.AllArgsConstructor;
import org.example.gestionpatients.entities.Patient;
import org.example.gestionpatients.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;
    @GetMapping("/index")
    public String index(Model model){
        List<Patient> patientList = patientRepository.findAll();
        model.addAttribute("listPatients", patientList);
        return "Patients";
    }
}
