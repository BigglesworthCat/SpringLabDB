package ua.kriuchkov.springlab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kriuchkov.springlab.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
