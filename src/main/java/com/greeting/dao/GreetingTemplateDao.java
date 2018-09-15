package com.greeting.dao;

import com.greeting.model.Template;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class GreetingTemplateDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Template create(Template template) {
        entityManager.persist(template);
        return template;
    }

    public Template getById(Integer id) {
        return (Template) entityManager.createNativeQuery("SELECT * FROM template WHERE id = :id", Template.class).setParameter("id", id).getSingleResult();
    }

    public List<Template> getAll() {
        return entityManager.createNativeQuery("SELECT * FROM template", Template.class).getResultList();
    }
}
