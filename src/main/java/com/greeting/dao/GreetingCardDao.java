package com.greeting.dao;

import com.greeting.model.Card;
import com.greeting.model.Template;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class GreetingCardDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Card create(Card card) {
        entityManager.persist(card);
        return card;
    }

    public List<Card> getAll() {
        return entityManager.createQuery("SELECT c FROM Card c", Card.class).getResultList();
    }
}
