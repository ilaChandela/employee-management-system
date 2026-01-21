package com.example.ems.controller;

import com.example.ems.dto.DepartmentRequestDto;
import com.example.ems.dto.DepartmentResponseDto;
import com.example.ems.entity.Department;
import com.example.ems.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public DepartmentResponseDto createDepartment(
            @RequestBody DepartmentRequestDto dto) {
        return departmentService.createDepartment(dto);
    }

    @GetMapping
    public List<DepartmentResponseDto> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public DepartmentResponseDto getDepartmentById(@PathVariable Long id) {
        return departmentService.getDepartmentById(id);
    }

//    @PostMapping
//    public Department createDepartment(@RequestBody Department department) {
//        return departmentService.createDepartment(department);
//    }
//
//    @GetMapping
//    public List<Department> getAllDepartments() {
//        return departmentService.getAllDepartments();
//    }
//
//    @GetMapping("/{id}")
//    public Department getDepartmentById(@PathVariable Long id) {
//        return departmentService.getDepartmentById(id);
//    }
}

