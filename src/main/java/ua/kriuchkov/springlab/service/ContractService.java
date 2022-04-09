package ua.kriuchkov.springlab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kriuchkov.springlab.model.Contract;
import ua.kriuchkov.springlab.repository.ContractRepository;

import java.util.List;

@Service
public class ContractService {
    public final ContractRepository contractRepository;

    @Autowired
    public ContractService(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    public Contract findById(Long id) {
        return contractRepository.findById(id).orElse(null);
    }

    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    public Contract saveContract(Contract contract) {
        return contractRepository.save(contract);
    }

    public void deleteById(Long id) {
        contractRepository.deleteById(id);
    }
}
