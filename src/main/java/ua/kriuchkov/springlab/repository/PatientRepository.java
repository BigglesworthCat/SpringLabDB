package ua.kriuchkov.springlab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kriuchkov.springlab.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
