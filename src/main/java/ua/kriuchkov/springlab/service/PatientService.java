package ua.kriuchkov.springlab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kriuchkov.springlab.model.Patient;
import ua.kriuchkov.springlab.repository.PatientRepository;

import java.util.List;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient findById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    public Patient savePatient(Patient doctor) {
        return patientRepository.save(doctor);
    }

    public void deleteById(Long id) {
        patientRepository.deleteById(id);
    }
}
