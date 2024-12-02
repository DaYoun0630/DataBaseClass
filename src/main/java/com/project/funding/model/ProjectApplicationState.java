package com.project.funding.model;

import com.project.funding.repository.State;

public enum ProjectApplicationState implements State {
    PENDING("승인 대기 중"),
    APPROVED("승인됨"),
    REJECTED("반려됨");

    private final String stateName;

    ProjectApplicationState(String stateName) {
        this.stateName = stateName;
    }

    @Override
    public String getStateName() {
        return stateName;
    }
}
