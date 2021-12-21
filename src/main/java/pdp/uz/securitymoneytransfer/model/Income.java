package pdp.uz.securitymoneytransfer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Income {
    private Integer id;
    private Integer from_card_id;
    private Integer to_card_id;
    private double amount;
    private String date;
}
