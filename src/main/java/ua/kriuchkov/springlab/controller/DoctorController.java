package ua.kriuchkov.springlab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.kriuchkov.springlab.model.Doctor;
import ua.kriuchkov.springlab.service.DoctorService;

import java.util.List;

@Controller
@RequestMapping("/doctors")
public class DoctorController {
    public final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/list")
    public String findAll(Model model) {
        List<Doctor> doctors = doctorService.findAll();
        model.addAttribute("doctors", doctors);
        return "doctors/doctor-list";
    }

    @GetMapping("/doctor-create")
    public String createDoctorForm(Doctor doctor) {
        return "doctors/doctor-create";
    }

    @PostMapping("/doctor-create")
    public String createDoctor(Doctor doctor) {
        doctorService.saveDoctor(doctor);
        return "redirect:/doctors/list";
    }

    @GetMapping("/doctor-update/{id}")
    public String updateDoctorForm(@PathVariable("id") Long id, Model model) {
        Doctor doctor = doctorService.findById(id);
        model.addAttribute("doctor", doctor);
        return "/doctors/doctor-update";
    }

    @PostMapping("/doctor-update")
    public String updateDoctor(Doctor doctor) {
        doctorService.saveDoctor(doctor);
        return "redirect:/doctors/list";
    }

    @GetMapping("doctor-delete/{id}")
    public String deleteDoctor(@PathVariable("id") Long id) {
        doctorService.deleteById(id);
        return "redirect:/doctors/list";
    }
}
