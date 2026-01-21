package com.example.ems.dto;

import java.time.LocalDate;

public class EmployeeProjectResponseDto {

    private Long id;
    private LocalDate assignedDate;

    private EmployeeBasicDto employee;
    private ProjectResponseDto project;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(LocalDate assignedDate) {
        this.assignedDate = assignedDate;
    }

    public EmployeeBasicDto getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeBasicDto employee) {
        this.employee = employee;
    }

    public ProjectResponseDto getProject() {
        return project;
    }

    public void setProject(ProjectResponseDto project) {
        this.project = project;
    }
}
