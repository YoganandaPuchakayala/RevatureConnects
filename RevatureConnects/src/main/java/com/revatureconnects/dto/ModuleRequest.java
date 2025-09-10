package com.revatureconnects.dto;

import java.util.List;

import com.revatureconnects.entity.Modules;

public class ModuleRequest {
    private Modules module;
    private List<Long> topicIds;

    public Modules getModule() {
        return module;
    }

    public void setModule(Modules module) {
        this.module = module;
    }

    public List<Long> getTopicIds() {
        return topicIds;
    }

    public void setTopicIds(List<Long> topicIds) {
        this.topicIds = topicIds;
    }
}
