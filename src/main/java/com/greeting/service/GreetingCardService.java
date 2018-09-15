package com.greeting.service;

import com.greeting.dao.GreetingCardDao;
import com.greeting.dao.GreetingTemplateDao;
import com.greeting.dto.CardDto;
import com.greeting.exception.BusinessException;
import com.greeting.model.Card;
import com.greeting.model.Template;
import org.apache.commons.lang3.text.StrSubstitutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GreetingCardService {


    private GreetingCardDao greetingCardDao;
    private GreetingTemplateDao greetingTemplateDao;

    @Autowired
    public GreetingCardService(GreetingCardDao greetingCardDao, GreetingTemplateDao greetingTemplateDao) {
        this.greetingCardDao = greetingCardDao;
        this.greetingTemplateDao = greetingTemplateDao;
    }

    @Transactional
    public Card create(CardDto cardDto) throws BusinessException {
        if (cardDto.getParams() == null) {
            throw new BusinessException("Please write your information on all required fields");
        }
        Template template = greetingTemplateDao.getById(cardDto.getTemplateId());
        if (template == null) {
            throw new BusinessException("Template id isn't exist");
        }
        StrSubstitutor sub = new StrSubstitutor(cardDto.getParams());
        return greetingCardDao.create(new Card(sub.replace(template.getText()), template));
    }

    public List<Card> getAll() {
        return greetingCardDao.getAll();
    }
}
