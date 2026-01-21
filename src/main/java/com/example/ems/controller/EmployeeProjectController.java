package com.example.ems.controller;

import com.example.ems.dto.EmployeeProjectRequestDto;
import com.example.ems.dto.EmployeeProjectResponseDto;
import com.example.ems.entity.EmployeeProject;
import com.example.ems.service.EmployeeProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignments")
public class EmployeeProjectController {

    private final EmployeeProjectService employeeProjectService;

    public EmployeeProjectController(EmployeeProjectService employeeProjectService) {
        this.employeeProjectService = employeeProjectService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeProjectResponseDto assignEmployeeToProject(
            @RequestBody EmployeeProjectRequestDto employeeProject) {
        return employeeProjectService.assignEmployeeToProject(employeeProject);
    }

    // ✅ Get all employee-project mappings
    @GetMapping
    public List<EmployeeProjectResponseDto> getAllAssignments() {
        return employeeProjectService.getAllAssignments();
    }

    // ✅ Get projects assigned to a specific employee
    @GetMapping("/employee/{employeeId}")
    public List<EmployeeProjectResponseDto> getAssignmentsByEmployee(
            @PathVariable Long employeeId) {
        return employeeProjectService.getAssignmentsByEmployeeId(employeeId);
    }

//    @GetMapping("/employee/{employeeId}")
//    public List<EmployeeProject> getProjectsByEmployee(
//            @PathVariable Long employeeId) {
//        return employeeProjectService.getProjectsByEmployee(employeeId);
//    }
//
//    @GetMapping("/project/{projectId}")
//    public List<EmployeeProject> getEmployeesByProject(
//            @PathVariable Long projectId) {
//        return employeeProjectService.getEmployeesByProject(projectId);
//    }
}
