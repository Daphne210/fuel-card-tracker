package com.mets.tracker.fuelcardtracker.Service;

import com.mets.tracker.fuelcardtracker.Entity.Cards;
import com.mets.tracker.fuelcardtracker.Repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    @Autowired
    private CardRepository repo;

    public Cards saveDetails(Cards card) {
        repo.save(card);
        return card;
    }

    public List<Cards> getAllCardDetails(){
        return repo.findAll();
    }

    public Cards getCardDetails(Long cardID) {

        return repo.findById(cardID).orElse(null);
    }

    public String deleteDetails(Long cardID) {
        if(repo.existsById(cardID)) {
            repo.deleteById(cardID);
            return "Deleted Card with ID: " + cardID;
        }else{
            return "ID does not exist";
        }
    }


}
