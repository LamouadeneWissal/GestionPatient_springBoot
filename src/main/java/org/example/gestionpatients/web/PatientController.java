package org.example.gestionpatients.web;

import lombok.AllArgsConstructor;
import org.example.gestionpatients.entities.Patient;
import org.example.gestionpatients.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;
    @GetMapping("/index")
    public String index(Model model, @RequestParam(name = "p",defaultValue = "0")int page,@RequestParam(name = "s")int size){
        Page<Patient> pagePatient = patientRepository.findAll(PageRequest.of(page,size));
        model.addAttribute("listPatients", pagePatient.getContent());
        model.addAttribute("pages", new int[pagePatient.getTotalPages()]);
        return "Patients";
    }
}
