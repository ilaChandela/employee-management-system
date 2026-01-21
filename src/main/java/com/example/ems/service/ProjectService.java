package com.example.ems.service;

import com.example.ems.dto.ProjectRequestDto;
import com.example.ems.dto.ProjectResponseDto;
import com.example.ems.entity.Project;

import java.util.List;

public interface ProjectService {

    ProjectResponseDto createProject(ProjectRequestDto dto);

    List<ProjectResponseDto> getAllProjects();

    ProjectResponseDto getProjectById(Long id);

    void deleteProject(Long id);

//    Project createProject(Project project);
//
//    List<Project> getAllProjects();
//
//    Project getProjectById(Long id);
}
