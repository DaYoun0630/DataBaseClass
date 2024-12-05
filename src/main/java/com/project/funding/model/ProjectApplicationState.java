package com.project.funding.model;

import com.project.funding.repository.State;

public enum ProjectApplicationState implements State {
    PENDING("승인 대기 중"),
    APPROVED("승인됨"),
    REJECTED("반려됨");

    private final String displayName;

    ProjectApplicationState(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String getStateName() {
        return displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static ProjectApplicationState fromDisplayName(String displayName) {
        for (ProjectApplicationState state : values()) {
            if (state.displayName.equals(displayName)) {
                return state;
            }
        }
        throw new IllegalArgumentException("Unknown displayName: " + displayName);
    }
}
