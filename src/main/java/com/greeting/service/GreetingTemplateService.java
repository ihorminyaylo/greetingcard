package com.greeting.service;

import com.greeting.dao.GreetingTemplateDao;
import com.greeting.exception.BusinessException;
import com.greeting.model.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class GreetingTemplateService {

    @Autowired
    private GreetingTemplateDao greetingTemplateDao;

    @Autowired
    public GreetingTemplateService(GreetingTemplateDao greetingTemplateDao) {
        this.greetingTemplateDao = greetingTemplateDao;
    }

    public Template create(Template template) throws BusinessException {
        validate(template);
        return greetingTemplateDao.create(template);
    }

    public List<Template> getAll() {
        return greetingTemplateDao.getAll();
    }

    private void validate(Template template) throws BusinessException {
        String text = template.getText();
        List<String> params = new ArrayList<>();
        for (String parameter: params) {
            if (!text.contains("${" + parameter + "}")) {
                throw new BusinessException("You should write your parameter to text like ${your parameter}");
            }
        }
    }
}
