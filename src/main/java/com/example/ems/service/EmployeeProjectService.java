package com.example.ems.service;

import com.example.ems.dto.EmployeeProjectRequestDto;
import com.example.ems.dto.EmployeeProjectResponseDto;
import com.example.ems.entity.EmployeeProject;

import java.util.List;

public interface EmployeeProjectService {

    EmployeeProjectResponseDto assignEmployeeToProject(EmployeeProjectRequestDto dto);

    List<EmployeeProjectResponseDto> getAllAssignments();

    List<EmployeeProjectResponseDto> getAssignmentsByEmployeeId(Long employeeId);
}
