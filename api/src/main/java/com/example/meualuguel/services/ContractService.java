package com.example.meualuguel.services;

import com.example.meualuguel.dtos.contract.ContractRequestDTO;
import com.example.meualuguel.dtos.contract.ContractResponseDTO;
import com.example.meualuguel.exceptions.ResourceNotFoundException;
import com.example.meualuguel.models.Contract;
import com.example.meualuguel.models.Property;
import com.example.meualuguel.models.User;
import com.example.meualuguel.repositories.ContractRepository;
import com.example.meualuguel.repositories.PropertyRepository;
import com.example.meualuguel.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ContractService {
    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private UserRepository userRepository;

    public List<ContractResponseDTO> getAllContracts() {
        return contractRepository.findAll().stream().map(ContractResponseDTO::new).toList();
    }

    public Optional<ContractResponseDTO> getContractById(Long contract_id) {
        return contractRepository.findById(contract_id).map(ContractResponseDTO::new);
    }

    public Optional<Contract> findContractById(Long contract_id) {
        return contractRepository.findById(contract_id);
    }

    public ContractResponseDTO createContract(ContractRequestDTO data) {
        Property property = propertyRepository.findById(data.property_id())
                .orElseThrow(() -> new ResourceNotFoundException("property_id not found"));
        User owner = userRepository.findById(data.owner_id())
                .orElseThrow(() -> new ResourceNotFoundException("owner_id not found"));
        User renter = userRepository.findById(data.renter_id())
                .orElseThrow(() -> new ResourceNotFoundException("renter_id not found"));

        boolean isPropertyRented = contractRepository.existsByPropertyIdAndIsActive(data.property_id(), true);
        if (isPropertyRented) {
            throw new IllegalStateException("Property is already rented");
        }
        if (!property.getIs_active()) {
            throw new IllegalStateException("Property is not active");
        }

        if (!owner.getIs_active()) {
            throw new IllegalStateException("Owner is not active");
        }

        if (!renter.getIs_active()) {
            throw new IllegalStateException("Renter is not active");
        }

        if (owner.getId().equals(renter.getId())) {
            throw new IllegalArgumentException("Owner and renter cannot be the same person");
        }

        if (!"Locador".equals(owner.getProfile().getName())) {
            throw new IllegalArgumentException("Owner must have profile of Locador");
        }

        if (!"Locatário".equals(renter.getProfile().getName())) {
            throw new IllegalArgumentException("Renter must have profile of Locatário");
        }

        if (data.start_date().plusMonths(data.duration()).isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("End date must be in the future");
        }

        LocalDate end_date = data.start_date().plusMonths(data.duration()).minusDays(1);

        Contract newContract = new Contract(data, property, owner, renter, end_date);
        contractRepository.save(newContract);
        return new ContractResponseDTO(newContract);
    }

    public Optional<ContractResponseDTO> cancelContract(Long contractId) {
        return contractRepository.findById(contractId)
                .map(contract -> {
                    if (!contract.getIsActive()) {
                        throw new IllegalStateException("Contrato já está cancelado");
                    }
                    contract.setIsActive(false);
                    Contract updated = contractRepository.save(contract);
                    return new ContractResponseDTO(updated);
                });
    }
}
