package com.mets.tracker.fuelcardtracker.Controller;

import com.mets.tracker.fuelcardtracker.Entity.Cards;
import com.mets.tracker.fuelcardtracker.Service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class CardController {

    @Autowired
    private CardService cardServices;

    @RequestMapping(value = "/registerCard", method = RequestMethod.GET)
    public ModelAndView registerCard()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cardRegister.html");
        return modelAndView;
    }

    @RequestMapping(value = "/saveCard", method = RequestMethod.POST)
    public ModelAndView saveCard(@ModelAttribute("card") Cards card, ModelMap model){
        cardServices.saveDetails(card);
        ModelAndView modelAndView = new ModelAndView("cardIndex.html",model);
        return modelAndView;
    }

    @RequestMapping(value="/")
    public ModelAndView indexCard(ModelMap model)
    {
        List<Cards> card = cardServices.getAllCardDetails();
        model.addAttribute("card",card);

        return new ModelAndView("/cardIndex.html",model);
    }

    @PostMapping("/addCards")
    public Cards addNewCard(@RequestBody Cards card){
        return cardServices.saveDetails(card);
    }

    @DeleteMapping("/deleteCard/{cardID}")
    public String deleteCard(@PathVariable Long cardID){
        return cardServices.deleteDetails(cardID);
    }

    @GetMapping("/getCards/{cardID}")
    public Cards fetchCardDetails(@PathVariable Long cardID){
        return cardServices.getCardDetails(cardID);
    }

    @GetMapping("/getCards")
    public List<Cards> getAllCardDetails(){
        return cardServices.getAllCardDetails();
    }

}