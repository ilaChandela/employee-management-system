package com.example.ems.service;

import com.example.ems.dto.DepartmentRequestDto;
import com.example.ems.dto.DepartmentResponseDto;
import com.example.ems.entity.Department;

import java.util.List;

public interface DepartmentService {
    DepartmentResponseDto createDepartment(DepartmentRequestDto department);

    List<DepartmentResponseDto> getAllDepartments();

    DepartmentResponseDto getDepartmentById(Long id);
}

