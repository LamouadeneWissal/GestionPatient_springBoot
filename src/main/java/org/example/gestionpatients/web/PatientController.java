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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;
    @GetMapping("/index")
    public String index(Model model, @RequestParam(name = "page",defaultValue = "0")int page,@RequestParam(name = "s",defaultValue = "5")int size , @RequestParam(name="keyword", defaultValue ="")String kw){
        Page<Patient> pagePatient = patientRepository.findByNameContains(kw,PageRequest.of(page,size));
        model.addAttribute("listPatients", pagePatient.getContent());
        model.addAttribute("pages",
                java.util.stream.IntStream.range(0, pagePatient.getTotalPages()).toArray());        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", kw);
        return "Patients";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam Integer id, String keyword, int page){
        patientRepository.deleteById(id);
        return "redirect:/index?page="+page+"&keyword="+keyword;
    }
    @GetMapping("/formPatients")
    public String formPatients(Model model){
        model.addAttribute("patient",new Patient() );
        return "formPatients";
    }
     @PostMapping("/save")
    public String save(Model model, Patient patient){
        patientRepository.save(patient);
        return "redirect:/index";
     }
}

