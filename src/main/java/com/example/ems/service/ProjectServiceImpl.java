package com.example.ems.service;

import com.example.ems.dto.ProjectRequestDto;
import com.example.ems.dto.ProjectResponseDto;
import com.example.ems.entity.Project;
import com.example.ems.mapper.ProjectMapper;
import com.example.ems.repository.ProjectRepository;
import com.example.ems.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }


    @Override
    public ProjectResponseDto createProject(ProjectRequestDto dto) {
        Project project = ProjectMapper.toEntity(dto);
        Project saved = projectRepository.save(project);
        return ProjectMapper.toDto(saved);
    }

    @Override
    public List<ProjectResponseDto> getAllProjects() {
        return projectRepository.findAll()
                .stream()
                .map(ProjectMapper::toDto)
                .toList();
    }

    @Override
    public ProjectResponseDto getProjectById(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found"));
        return ProjectMapper.toDto(project);
    }

    @Override
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}
