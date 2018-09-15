package com.greeting.dto;

import java.util.Map;

public class CardDto {
    private Integer templateId;
    private Map<String, String> params;

    public CardDto() {
    }

    public CardDto(Integer templateId, Map<String, String> params) {
        this.templateId = templateId;
        this.params = params;
    }

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }
}
