package com.example.ems.service;

import com.example.ems.dto.EmployeeProjectRequestDto;
import com.example.ems.dto.EmployeeProjectResponseDto;
import com.example.ems.entity.Employee;
import com.example.ems.entity.EmployeeProject;
import com.example.ems.entity.Project;
import com.example.ems.mapper.EmployeeProjectMapper;
import com.example.ems.repository.EmployeeProjectRepository;
import com.example.ems.repository.EmployeeRepository;
import com.example.ems.repository.ProjectRepository;
import com.example.ems.service.EmployeeProjectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeProjectServiceImpl implements EmployeeProjectService {

    private final EmployeeRepository employeeRepository;
    private final ProjectRepository projectRepository;
    private final EmployeeProjectRepository employeeProjectRepository;

    public EmployeeProjectServiceImpl(EmployeeRepository employeeRepository,
                                      ProjectRepository projectRepository,
                                      EmployeeProjectRepository employeeProjectRepository) {
        this.employeeRepository = employeeRepository;
        this.projectRepository = projectRepository;
        this.employeeProjectRepository = employeeProjectRepository;
    }


    @Override
    public EmployeeProjectResponseDto assignEmployeeToProject(EmployeeProjectRequestDto dto) {

        Employee employee = employeeRepository.findById(dto.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        Project project = projectRepository.findById(dto.getProjectId())
                .orElseThrow(() -> new RuntimeException("Project not found"));

        EmployeeProject ep = new EmployeeProject();
        ep.setEmployee(employee);
        ep.setProject(project);
        ep.setAssignedDate(dto.getAssignedDate());

        EmployeeProject saved = employeeProjectRepository.save(ep);

        return EmployeeProjectMapper.toResponseDto(saved);
    }

    @Override
    public List<EmployeeProjectResponseDto> getAllAssignments() {
        return employeeProjectRepository.findAll()
                .stream()
                .map(EmployeeProjectMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeProjectResponseDto> getAssignmentsByEmployeeId(Long employeeId) {
        return employeeProjectRepository.findByEmployeeId(employeeId)
                .stream()
                .map(EmployeeProjectMapper::toResponseDto)
                .collect(Collectors.toList());
    }

//    @Override
//    public EmployeeProject assignEmployeeToProject(EmployeeProject employeeProject) {
//        return employeeProjectRepository.save(employeeProject);
//    }
//
//    @Override
//    public List<EmployeeProject> getProjectsByEmployee(Long employeeId) {
//        return employeeProjectRepository.findByEmployeeId(employeeId);
//    }
//
//    @Override
//    public List<EmployeeProject> getEmployeesByProject(Long projectId) {
//        return employeeProjectRepository.findByProjectId(projectId);
//    }
}
