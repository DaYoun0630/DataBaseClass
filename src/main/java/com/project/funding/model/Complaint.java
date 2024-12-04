package com.project.funding.model;

import javax.persistence.*;

@Entity
@Table(name = "complaint")
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "complaint_id") // complaint_id와 매핑
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "complaint_content", nullable = false)
    private String content;

    @Column(name = "complaint_creation_date", nullable = false)
    private String creationDate;

    @Convert(converter = ComplaintStateConverter.class)
    @Column(name = "complaint_status_type", nullable = false)
    private ComplaintState statusType;

    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "complaint_answer")
    private String answer;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public ComplaintState getStatusType() {
        return statusType;
    }

    public void setStatusType(ComplaintState statusType) {
        this.statusType = statusType;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
