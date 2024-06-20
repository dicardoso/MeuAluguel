package com.example.meualuguel.repositories;

import com.example.meualuguel.models.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Long> {
    boolean existsByPropertyIdAndIsActive(Long aLong, boolean b);
}
