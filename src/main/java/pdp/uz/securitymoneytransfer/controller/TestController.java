package pdp.uz.securitymoneytransfer.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {
    @PostMapping("/test")
    public HttpEntity<String> test(){
        return ResponseEntity.ok("Testni sistemasiga kirishga ruxsat berildi");
    }
}
