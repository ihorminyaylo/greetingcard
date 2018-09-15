package com.greeting.dao;

import com.greeting.model.Template;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class GreetingTemplateDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Template create(Template template) {
        entityManager.persist(template);
        return template;
    }

    public Template getById(Integer id) {
        return entityManager.find(Template.class, id);
    }

    public List<Template> getAll() {
        return entityManager.createQuery("SELECT t FROM Template t", Template.class).getResultList();
    }
}
