package com.example.meualuguel.controllers;

import com.example.meualuguel.dtos.contract.ContractRequestDTO;
import com.example.meualuguel.dtos.contract.ContractResponseDTO;
import com.example.meualuguel.exceptions.ResourceNotFoundException;
import com.example.meualuguel.models.Contract;
import com.example.meualuguel.services.ContractService;
import com.example.meualuguel.services.PdfService;
import com.example.meualuguel.utils.CpfUtils;
import com.example.meualuguel.utils.CurrencyUtils;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.context.Context;

import jakarta.validation.Valid;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RestController
@RequestMapping("contract")
public class ContractController {
    @Autowired
    private ContractService contractService;

    @Autowired
    private PdfService pdfService;

    @GetMapping()
    public List<ContractResponseDTO> getAll() {
        return contractService.getAllContracts();
    }

    @GetMapping("/{contract_id}")
    public ResponseEntity<ContractResponseDTO> getContractById(@PathVariable Long contract_id) {
        Optional<ContractResponseDTO> contractOpt = contractService.getContractById(contract_id);
        return contractOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ContractResponseDTO> saveContract(@Valid @RequestBody ContractRequestDTO data) {
        try {
            ContractResponseDTO newContract = contractService.createContract(data);
            return ResponseEntity.ok(newContract);
        } catch (IllegalStateException | IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{contract_id}/cancel")
    public ResponseEntity<ContractResponseDTO> cancelContract(@PathVariable Long contract_id) {
        Optional<ContractResponseDTO> contractOpt = contractService.cancelContract(contract_id);
        return contractOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{contract_id}/generate")
    public ResponseEntity<byte[]> generateDocument(@PathVariable Long contract_id) {
        Optional<Contract> contractOpt = contractService.findContractById(contract_id);

        if (contractOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Contract contract = contractOpt.get();

        try {
            Context context = new Context();
            context.setVariable("contract", contract);
            context.setVariable("owner", contract.getOwner());
            context.setVariable("renter", contract.getRenter());
            context.setVariable("property", contract.getProperty());

            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd 'de' MMMM 'de' yyyy", new Locale("pt", "BR"));

            context.setVariable("signDate", contract.getSign_date().format(dateFormat));
            context.setVariable("startDate", contract.getStart_date().format(dateFormat));
            context.setVariable("endDate", contract.getEnd_date().format(dateFormat));
            context.setVariable("value", CurrencyUtils.formatCurrency(contract.getValue()));
            context.setVariable("valueInWords", CurrencyUtils.convertDoubleToWords(contract.getValue()));
            context.setVariable("ownerCpf", CpfUtils.formatCPF(contract.getOwner().getRegistry()));
            context.setVariable("renterCpf", CpfUtils.formatCPF(contract.getRenter().getRegistry()));

            byte[] pdfContents = pdfService.generatePdf("pdfTemplate", context);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("attachment", "contract_" + contract_id + ".pdf");

            return ResponseEntity.ok()
                    .headers(headers)
                    .body(pdfContents);

        } catch (DocumentException | IOException e) {
            return ResponseEntity.status(500).body(null);
        } catch (com.itextpdf.text.DocumentException e) {
            throw new RuntimeException(e);
        }
    }
}
