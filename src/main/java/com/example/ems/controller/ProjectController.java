package com.example.ems.controller;

import com.example.ems.dto.ProjectRequestDto;
import com.example.ems.dto.ProjectResponseDto;
import com.example.ems.entity.Project;
import com.example.ems.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProjectResponseDto createProject(@RequestBody ProjectRequestDto dto) {
        return projectService.createProject(dto);
    }

    @GetMapping
    public List<ProjectResponseDto> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/{id}")
    public ProjectResponseDto getProjectById(@PathVariable Long id) {
        return projectService.getProjectById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
    }

//    @PostMapping
//    public Project createProject(@RequestBody Project project) {
//        return projectService.createProject(project);
//    }
//
//    @GetMapping
//    public List<Project> getAllProjects() {
//        return projectService.getAllProjects();
//    }
//
//    @GetMapping("/{id}")
//    public Project getProjectById(@PathVariable Long id) {
//        return projectService.getProjectById(id);
//    }
}
