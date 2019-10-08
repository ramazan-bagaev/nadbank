package com.kanasuki.nadbank.backend;

import com.kanasuki.nadbank.backend.bank.Bank;
import com.kanasuki.nadbank.backend.bank.BankRepository;
import com.kanasuki.nadbank.backend.cashback.Cashback;
import com.kanasuki.nadbank.backend.debit.DebitCard;
import com.kanasuki.nadbank.backend.debit.DebitCardRepository;
import com.kanasuki.nadbank.backend.product.Product;
import com.kanasuki.nadbank.backend.product.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableAutoConfiguration
public class Application {

    public static void main(String[] argv) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demo(DebitCardRepository repository, BankRepository bankRepository, ProductRepository productRepository) {
        return args -> {
            Bank bank = new Bank("ny-bank");
            bankRepository.save(bank);
            repository.save(new DebitCard(1L, new Cashback(2D)));
            productRepository.save(new Product("productName", bank));
            /*bankRepository.save(new Bank("my-bank"));
            bankRepository.save(new Bank("my-other-bank"));
            bankRepository.save(new Bank("not-my-bank"));*/
        };
    }
}
