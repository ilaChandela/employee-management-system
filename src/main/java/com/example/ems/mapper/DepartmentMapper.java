package com.example.ems.mapper;

import com.example.ems.dto.DepartmentRequestDto;
import com.example.ems.dto.DepartmentResponseDto;
import com.example.ems.entity.Department;

public class DepartmentMapper {

    // Request DTO → Entity
    public static Department toEntity(DepartmentRequestDto dto) {
        Department department = new Department();
        department.setName(dto.getName());
        department.setLocation(dto.getLocation());
        return department;
    }

    // Entity → Response DTO
    public static DepartmentResponseDto toResponseDto(Department department) {
        DepartmentResponseDto dto = new DepartmentResponseDto();
        dto.setId(department.getId());
        dto.setName(department.getName());
        dto.setLocation(department.getLocation());
        return dto;
    }

//    public static DepartmentResponseDto toDto(Department department) {
//        DepartmentResponseDto dto = new DepartmentResponseDto();
//        dto.setId(department.getId());
//        dto.setName(department.getName());
//        dto.setLocation(department.getLocation());
//        return dto;
//    }
}

