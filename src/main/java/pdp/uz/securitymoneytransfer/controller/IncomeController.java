package pdp.uz.securitymoneytransfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pdp.uz.securitymoneytransfer.model.Income;
import pdp.uz.securitymoneytransfer.service.IncomeService;

@RestController
@RequestMapping("/api")
public class IncomeController {
    @Autowired
    IncomeService incomeService;

    @PostMapping("/income")
    public ResponseEntity<?> incomePay(@RequestBody Income income){
        String incomePay = incomeService.incomePay(income);
        return ResponseEntity.ok(incomePay);
    }
}
