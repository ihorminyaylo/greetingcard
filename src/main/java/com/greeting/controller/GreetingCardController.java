package com.greeting.controller;

import com.greeting.dto.CardDto;
import com.greeting.exception.BusinessException;
import com.greeting.model.Template;
import com.greeting.service.GreetingCardService;
import com.greeting.service.GreetingTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/greetingCard")
public class GreetingCardController {

    private final GreetingTemplateService greetingTemplateService;

    private final GreetingCardService greetingCardService;

    @Autowired
    public GreetingCardController(GreetingTemplateService greetingTemplateService, GreetingCardService greetingCardService) {
        this.greetingTemplateService = greetingTemplateService;
        this.greetingCardService = greetingCardService;
    }

    @GetMapping(value = "/catalog")
    public ResponseEntity<List<Template>> getAll() {
        return ResponseEntity.ok(greetingTemplateService.getAll());
    }

    @GetMapping(value = "/cards")
    public ResponseEntity<List<Template>> getAllCards() {
        return ResponseEntity.ok(greetingCardService.getAll());
    }

    @PutMapping
    public ResponseEntity createTempate(@RequestBody Template template) throws BusinessException {
        return ResponseEntity.ok(greetingTemplateService.create(template));
    }

    @PostMapping
    public ResponseEntity createCard(@RequestBody CardDto cardDto) throws BusinessException {
        return ResponseEntity.ok(greetingCardService.create(cardDto));
    }
}
