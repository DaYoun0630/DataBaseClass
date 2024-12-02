package com.project.funding.model;
//민원

import com.project.funding.repository.StatefulEntity;

import javax.persistence.*;

@Entity
@Table(name = "complaints")
public class Complaint implements StatefulEntity<ComplaintState> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "state", nullable = false)
    private ComplaintState state = ComplaintState.PENDING;

    // Other fields...

    @Override
    public ComplaintState getState() {
        return state;
    }

    @Override
    public void setState(ComplaintState state) {
        this.state = state;
    }
}