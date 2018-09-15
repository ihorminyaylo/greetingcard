package com.greeting.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Arrays;
import java.util.List;

@Entity
public class Template extends AbstractEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String text;

    @Column
    private String params;

    public Template() {
    }

    public Template(String name, String text, String params) {
        this.name = name;
        this.text = text;
        this.params = params;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getParams() {
        return Arrays.asList(params.split(","));
    }

    public void setParams(List<String> list) {
        params = String.join(",", list);
    }

}
