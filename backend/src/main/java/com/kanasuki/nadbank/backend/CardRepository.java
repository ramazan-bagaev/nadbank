package com.kanasuki.nadbank.backend;

import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface CardRepository extends CrudRepository<Card, Long> {
}
