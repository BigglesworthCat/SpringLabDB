package ua.kriuchkov.springlab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kriuchkov.springlab.model.Contract;

public interface ContractRepository extends JpaRepository<Contract, Long> {
}
