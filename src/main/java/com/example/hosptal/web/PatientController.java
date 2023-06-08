package com.example.hosptal.web;

import com.example.hosptal.entities.Patient;
import com.example.hosptal.repository.PatientRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;

    @GetMapping(value = {"/index",""})
    public String index(Model model ,
                        @RequestParam(name = "page", defaultValue = "0") int page ,
                        @RequestParam(name = "size", defaultValue = "4") int size,
                        @RequestParam(name = "keyword", defaultValue = "") String kw) {
        Page<Patient> patientPage= patientRepository.findByNomContains(kw,PageRequest.of(page,size));
        model.addAttribute("listPatients",patientPage.getContent());
        model.addAttribute("pages",new int[patientPage.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword", kw);
        return "patients";
    }

    @GetMapping(value = "/delete")
    public String delete(Long id,
                         @RequestParam(name = "page", defaultValue = "0") int page,
                         @RequestParam(name = "keyword", defaultValue = "") String kw){
        patientRepository.deleteById(id);
        return "redirect:/index?page="+page+"&keyword="+kw;
    }

    @GetMapping(value = "/formPatients")
    public String formPatient(Model model){
        model.addAttribute("patient",new Patient());
        return "formPatients";
    }

    @PostMapping(value = "/savePatient")
    public String savePatient(@Valid Patient patient, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "formPatients";
        }
        patientRepository.save(patient);
        return "redirect:/index?keyword="+patient.getNom();
    }

    @GetMapping(value = "/editPatient")
    public String editPatient(Model model, @RequestParam(name = "id") Long id){
        Patient patient= patientRepository.findById(id).get();
        model.addAttribute("patient", patient);
        return "editPatient";
    }
}
