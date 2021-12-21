package pdp.uz.securitymoneytransfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pdp.uz.securitymoneytransfer.model.Outcome;
import pdp.uz.securitymoneytransfer.service.OutcomeService;

@RestController
@RequestMapping("/api")
public class OutcomeController {
    @Autowired
    OutcomeService outcomeService;

    @PostMapping("/outcome")
    public HttpEntity<?> outcomePay(@RequestBody Outcome outcome){
        String outcomePay = outcomeService.outcomePay(outcome);
        return ResponseEntity.ok(outcomePay);
    }
}
