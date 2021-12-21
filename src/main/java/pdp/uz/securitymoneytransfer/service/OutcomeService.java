package pdp.uz.securitymoneytransfer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pdp.uz.securitymoneytransfer.model.Card;
import pdp.uz.securitymoneytransfer.model.Outcome;

@Service
public class OutcomeService {

    @Autowired
    CardService cardService;

    public String outcomePay(Outcome outcome){
        Card fromCard = null;
        Card toCard = null;
        //Array Listdagi kartalarni aylanib chiqadi
        for (Card card : cardService.cardList) {
            //har bir kartani id sini Postmandan kiritilayotgan from_card_id sini tengligini tekshiradi va fromCardga saqlaydi
            if (card.getId()== outcome.getFrom_card_id()){
                fromCard = card;
            }
            //har bir kartani id sini Postmandan kiritilayotgan to_card_id sini tengligini tekshiradi va tocardga saqlaydi
            if (card.getId() == outcome.getTo_card_id()){
                toCard = card;
            }
        }
        //Yuqorida Aylanib chiqgan kartalarni fromCardga saqlab uni bosh emasligini tekshiradi
        if (fromCard!=null){
            if (toCard!=null){
                //Mablag yetarli ekanligini tekshiradi
                    if (cardService.cardList.get(outcome.getFrom_card_id()-1).getBalance() >= outcome.getAmount()){
                        cardService.cardList.get(  outcome.getFrom_card_id()-1 ).setBalance(  cardService.cardList.get(  outcome.getFrom_card_id()-1  ).getBalance()- (outcome.getAmount() + (outcome.getAmount() * outcome.getCommision_amount()) ) );
                        cardService.cardList.get(  outcome.getTo_card_id()-1  ).setBalance( cardService.cardList.get( outcome.getTo_card_id()-1 ).getBalance()+outcome.getAmount() );
                    }else {
                        return "Mablag yetarli emas!";
                    }


            }else {
                return "ToCard xato kiritildi";
            }

        }else {
            return "FromCard xato kiritildi";
        }

        return "Kartangizdan mablag' o'tkazildi!";
    }
}
