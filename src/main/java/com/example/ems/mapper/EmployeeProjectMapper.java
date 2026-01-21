package com.example.ems.mapper;

import com.example.ems.dto.*;
import com.example.ems.entity.*;

public class EmployeeProjectMapper {

    public static EmployeeProjectResponseDto toResponseDto(EmployeeProject ep) {

        if (ep == null) return null;

        EmployeeProjectResponseDto dto = new EmployeeProjectResponseDto();
        dto.setId(ep.getId());
        dto.setAssignedDate(ep.getAssignedDate());

        // ---- Employee (BASIC DTO) ----
        Employee emp = ep.getEmployee();
        if (emp != null) {
            EmployeeBasicDto ebd = new EmployeeBasicDto();
            ebd.setId(emp.getId());
            ebd.setFirstName(emp.getFirstName());
            ebd.setLastName(emp.getLastName());
            ebd.setEmail(emp.getEmail());
            dto.setEmployee(ebd);
        }

        // ---- Project (RESPONSE DTO) ----
        Project project = ep.getProject();
        if (project != null) {
            ProjectResponseDto prd = new ProjectResponseDto();
            prd.setId(project.getId());
            prd.setName(project.getName());
            prd.setStartDate(project.getStartDate());
            prd.setEndDate(project.getEndDate());
            dto.setProject(prd);
        }

        return dto;
    }
}

