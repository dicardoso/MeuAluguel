package com.example.meualuguel.dtos.contract;

import com.example.meualuguel.dtos.property.PropertyResponseDTO;
import com.example.meualuguel.dtos.user.UserResponseDTO;
import com.example.meualuguel.models.Contract;
import com.example.meualuguel.models.Owner;
import com.example.meualuguel.models.Renter;

import java.time.LocalDate;
import java.util.Date;

public record ContractResponseDTO(Long id, PropertyResponseDTO property, UserResponseDTO ownerName, UserResponseDTO renterName, LocalDate start_date, LocalDate end_date, LocalDate sign_date, double value, Boolean is_active) {

    public ContractResponseDTO(Contract contract) {
        this(
                contract.getId(),
                new PropertyResponseDTO(contract.getProperty()),
                new UserResponseDTO(contract.getOwner()),
                new UserResponseDTO(contract.getRenter()),
                contract.getStart_date(),
                contract.getEnd_date(),
                contract.getSign_date(),
                contract.getValue(),
                contract.getIsActive()
        );
    }
}
