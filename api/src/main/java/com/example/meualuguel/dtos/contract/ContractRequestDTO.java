package com.example.meualuguel.dtos.contract;

import com.example.meualuguel.dtos.property.PropertyResponseDTO;
import com.example.meualuguel.dtos.user.UserResponseDTO;
import com.example.meualuguel.models.Contract;

import java.time.LocalDate;
import java.util.Date;

public record ContractRequestDTO(Long property_id, Long owner_id, Long renter_id, LocalDate start_date, Integer duration, LocalDate sign_date, Integer maturity_date, double value) {


    public ContractRequestDTO(Contract contract) {
        this(
                contract.getProperty().getId(),
                contract.getOwner().getId(),
                contract.getRenter().getId(),
                contract.getStart_date(),
                null,
                contract.getSign_date(),
                contract.getMaturity_date(),
                contract.getValue()
        );
    }
}
