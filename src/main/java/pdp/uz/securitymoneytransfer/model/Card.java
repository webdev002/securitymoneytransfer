package pdp.uz.securitymoneytransfer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Card {
    private  Integer id;
    private  String username;
    private  String number;
    private  double balance;
    private String date;
    private  boolean active;

}
