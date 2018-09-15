package com.greeting.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Card extends AbstractEntity {

    @Column(nullable = false)
    private String text;

    @ManyToOne
    @JoinColumn(name = "template_id")
    private Template template;

    public Card() {
    }

    public Card(String text, Template template) {
        this.text = text;
        this.template = template;
    }

    public Template getTemplate() {
        return template;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }
}
