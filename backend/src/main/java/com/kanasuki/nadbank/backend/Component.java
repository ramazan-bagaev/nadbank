package com.kanasuki.nadbank.backend;

import com.kanasuki.nadbank.backend.bank.Bank;
import com.kanasuki.nadbank.backend.bank.BankRepository;
import com.kanasuki.nadbank.backend.debit.DebitCard;
import com.kanasuki.nadbank.backend.debit.DebitCardRepository;
import com.kanasuki.nadbank.backend.product.Product;
import com.kanasuki.nadbank.backend.product.ProductRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.Collection;
import java.util.HashSet;

@RestController
public class Component {

    @Inject
    private DebitCardRepository debitCardRepository;

    @Inject
    private BankRepository bankRepository;

    @Inject
    private ProductRepository productRepository;

    @RequestMapping(value = "/banks", produces = "application/json")
    public Collection<Bank> banks() {
        Collection<Bank> banks = new HashSet<>();

        for(Bank bank: bankRepository.findAll()) {
            banks.add(bank);
        }

        return banks;
    }

    @RequestMapping(value = "/debitCards", produces = "application/json")
    public Collection<DebitCard> debitCards() {
        Collection<DebitCard> debitCards = new HashSet<>();

        for(DebitCard debitCard: debitCardRepository.findAll()) {
            debitCards.add(debitCard);
        }

        return debitCards;
    }

    @RequestMapping(value = "/products", produces = "application/json")
    public Collection<Product> products() {
        Collection<Product> products = new HashSet<>();

        for(Product product: productRepository.findAll()) {
            products.add(product);
        }

        return products;
    }
}
