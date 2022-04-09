package ua.kriuchkov.springlab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.kriuchkov.springlab.model.Contract;
import ua.kriuchkov.springlab.service.ContractService;

import java.util.List;

@Controller
@RequestMapping("/contracts")
public class ContractController {
    public final ContractService contractService;

    @Autowired
    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    @GetMapping("/list")
    public String findAll(Model model) {
        List<Contract> contracts = contractService.findAll();
        model.addAttribute("contracts", contracts);
        return "contracts/contract-list";
    }

    @GetMapping("/contract-create")
    public String createContractForm(Contract contract) {
        return "contracts/contract-create";
    }

    @PostMapping("/contract-create")
    public String createContract(Contract contract) {
        contractService.saveContract(contract);
        return "redirect:/contracts/list";
    }

    @GetMapping("/contract-update/{id}")
    public String updateContractForm(@PathVariable("id") Long id, Model model) {
        Contract contract = contractService.findById(id);
        model.addAttribute("contract", contract);
        return "/contracts/contract-update";
    }

    @PostMapping("/contract-update")
    public String updateContract(Contract contract) {
        contractService.saveContract(contract);
        return "redirect:/contracts/list";
    }

    @GetMapping("contract-delete/{id}")
    public String deleteContract(@PathVariable("id") Long id) {
        contractService.deleteById(id);
        return "redirect:/contracts/list";
    }
}
