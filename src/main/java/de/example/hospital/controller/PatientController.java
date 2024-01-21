package de.example.hospital.controller;

import de.example.hospital.entities.Patient;
import de.example.hospital.repository.PatientRepository;
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

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;

    @GetMapping("/index")
    public String listPatient(Model model,
                              @RequestParam(name = "paramPage",defaultValue = "0") int page,
                              @RequestParam(name = "paramSize", defaultValue = "4") int size,
                              @RequestParam(name = "paramSearch", defaultValue = "") String search)
                              //@RequestParam(name = "paramSearch", defaultValue = "") String searchVorname)
    {
        Page<Patient> patientList = patientRepository.findByNameContainingIgnoreCaseOrVornameContainingIgnoreCase(search, search,PageRequest.of(page,size));
        model.addAttribute("vueListPatients",patientList.getContent());
        model.addAttribute("vuePages", new int[patientList.getTotalPages()]);
        model.addAttribute("vueCurrentPage",page);
        model.addAttribute("vueSearch",search);
        return "vuePatients";
    }
    @GetMapping("/delete")
    public String delete(Long idM, String searchM, int currentPageM){
        patientRepository.deleteById(idM);
        return "redirect:/index?paramPage="+currentPageM+"&paramSearch="+searchM;
    }
    @GetMapping("/formPatients")
    public String formPatient(Model model){

        model.addAttribute("patient",new Patient());
        return "formPatients";
    }
    @GetMapping("/editPatient")
    public String editPatient(Model model,@RequestParam(name= "idM") Long idM){
        Patient patient = patientRepository.findById(idM).get();

        model.addAttribute("patient",patient);
        return "editPatients";
    }

    @PostMapping("/savePatient")
    public String savePatient(@Valid Patient patient, BindingResult bindingResult){
       if(bindingResult.hasErrors()){
            return "formPatients";
        }
        patientRepository.save(patient);
        return "redirect:/index?paramSearch="+patient.getName();
    }



}
