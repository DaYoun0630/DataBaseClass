package com.project.funding.model;

import com.project.funding.repository.State;

public enum ComplaintState implements State {
    PENDING("처리 대기 중"),
    IN_PROGRESS("처리 중"),
    COMPLETED("처리 완료");

    private final String stateName;

    ComplaintState(String stateName) {
        this.stateName = stateName;
    }

    @Override
    public String getStateName() {
        return stateName;
    }
}
