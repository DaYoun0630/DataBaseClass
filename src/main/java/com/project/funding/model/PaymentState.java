package com.project.funding.model;

import com.project.funding.repository.State;

public enum PaymentState implements State{
    PENDING("대기 중"),
    SUCCESS("성공"),
    FAILED("실패");

    private final String stateName;

    PaymentState(String stateName) {
        this.stateName = stateName;
    }

    @Override
    public String getStateName() {
        return stateName;
    }

}
