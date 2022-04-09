package ua.kriuchkov.springlab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ua.kriuchkov.springlab.model.Patient;
import ua.kriuchkov.springlab.model.Patient;
import ua.kriuchkov.springlab.service.PatientService;
import ua.kriuchkov.springlab.service.PatientService;

import java.util.List;

@Controller
public class PatientController {
    public final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patients")
    public String findAll(Model model) {
        List<Patient> patients = patientService.findAll();
        model.addAttribute("patients", patients);
        return "patient-list";
    }

    @GetMapping("/patient-create")
    public String createPatientForm(Patient patient) {
        return "patient-create";
    }

    @PostMapping("/patient-create")
    public String createPatient(Patient patient) {
        patientService.savePatient(patient);
        return "redirect:/patients";
    }

    @GetMapping("/patient-update/{id}")
    public String updatePatientForm(@PathVariable("id") Long id, Model model) {
        Patient patient = patientService.findById(id);
        model.addAttribute("patient", patient);
        return "/patient-update";
    }

    @PostMapping("/patient-update")
    public String updatePatient(Patient patient) {
        patientService.savePatient(patient);
        return "redirect:/patients";
    }

    @GetMapping("patient-delete/{id}")
    public String deletePatient(@PathVariable("id") Long id) {
        patientService.deleteById(id);
        return "redirect:/patients";
    }
}
