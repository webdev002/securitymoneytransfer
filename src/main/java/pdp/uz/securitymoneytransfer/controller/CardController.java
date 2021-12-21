package pdp.uz.securitymoneytransfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pdp.uz.securitymoneytransfer.payload.LoginDto;
import pdp.uz.securitymoneytransfer.service.CardService;

@RestController
@RequestMapping("/api")
public class CardController {

    @Autowired
    CardService cardService;

    @GetMapping("/card")
    public HttpEntity<?> CheckCard(@RequestBody LoginDto loginDto){
        String cardCheck = cardService.cardCheck(loginDto.getUsername());
        return ResponseEntity.status(200).body(cardCheck);
    }
}
