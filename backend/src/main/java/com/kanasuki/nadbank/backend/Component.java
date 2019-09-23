package com.kanasuki.nadbank.backend;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.Collection;
import java.util.HashSet;

@RestController
public class Component {

    @Inject
    private CardRepository cardRepository;

    @RequestMapping(value = "/card", produces = "application/json")
    public Collection<Card> index() {
        Collection<Card> cards = new HashSet<>();

        for(Card card: cardRepository.findAll()) {
            cards.add(card);
        }

        return cards;
    }
}
