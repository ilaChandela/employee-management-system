package com.example.ems.mapper;

import com.example.ems.dto.ProjectRequestDto;
import com.example.ems.dto.ProjectResponseDto;
import com.example.ems.entity.Project;

public class ProjectMapper {

    // Request DTO → Entity
    public static Project toEntity(ProjectRequestDto dto) {
        Project project = new Project();
        project.setName(dto.getName());
        project.setStartDate(dto.getStartDate());
        project.setEndDate(dto.getEndDate());
        return project;
    }

    // Entity → Response DTO
    public static ProjectResponseDto toDto(Project project) {
        ProjectResponseDto dto = new ProjectResponseDto();
        dto.setId(project.getId());
        dto.setName(project.getName());
        dto.setStartDate(project.getStartDate());
        dto.setEndDate(project.getEndDate());
        return dto;
    }
}
