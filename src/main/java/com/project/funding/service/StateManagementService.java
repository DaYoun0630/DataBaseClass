package com.project.funding.service;

import com.project.funding.model.ProjectApplication;
import com.project.funding.model.ProjectApplicationState;
import com.project.funding.repository.State;
import com.project.funding.repository.StatefulEntity;
import org.springframework.stereotype.Service;

// 엔터티의 상태를 관리하는 서비스 클래스
@Service
public class StateManagementService {

    // 엔터티의 상태를 새로운 상태로 업데이트
    public <T extends State> void updateState(StatefulEntity<T> entity, T newState) {
        entity.setState(newState); // 엔터티의 상태를 변경
    }

    // 엔터티의 현재 상태 이름 반환
    public <T extends State> String getCurrentStateName(StatefulEntity<T> entity) {
        return entity.getState().getStateName(); // 현재 상태 이름 반환
    }

}
