package com.greeting.model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
public class Template extends AbstractEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String text;

    @ElementCollection
    @CollectionTable(name = "Params", joinColumns = @JoinColumn(name = "param_id"))
    @Column(name="params")
    private List<String> params;

    public Template() {
    }

    public Template(String name, String text, List<String> params) {
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
        return params;
    }

    public void setParams(List<String> params) {
        this.params = params;
    }
}
