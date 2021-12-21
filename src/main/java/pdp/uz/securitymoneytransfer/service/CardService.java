package pdp.uz.securitymoneytransfer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pdp.uz.securitymoneytransfer.model.Card;
import pdp.uz.securitymoneytransfer.payload.LoginDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class CardService {
    @Autowired
    MyAuthService myAuthService;


    List<Card> cardList = new ArrayList<>(
            Arrays.asList(
                    new Card(1,"user","1243",770000,"12.12.21",true),
                    new Card(2,"golibjon","4321",7700,"12.12.21",true)
            )
    );

    public String cardCheck(String username){
        for (Card card : cardList) {
            if (card.getUsername().equals(username)){
                return "Karta egasi siz,sistemaga kirdingiz";
            }
        }
        throw new UsernameNotFoundException("Xatolik");
    }
}
