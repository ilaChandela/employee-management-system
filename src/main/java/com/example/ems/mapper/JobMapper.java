package com.example.ems.mapper;

import com.example.ems.dto.JobRequestDto;
import com.example.ems.dto.JobResponseDto;
import com.example.ems.entity.Job;

public class JobMapper {

    // Entity → Response DTO
    public static JobResponseDto toResponseDto(Job job) {
        if (job == null) return null;

        JobResponseDto dto = new JobResponseDto();
        dto.setId(job.getId());
        dto.setTitle(job.getTitle());
        dto.setMinSalary(job.getMinSalary());
        dto.setMaxSalary(job.getMaxSalary());
        return dto;
    }

    // Request DTO → Entity
    public static Job toEntity(JobRequestDto dto) {
        if (dto == null) return null;

        Job job = new Job();
        job.setTitle(dto.getTitle());
        job.setMinSalary(dto.getMinSalary());
        job.setMaxSalary(dto.getMaxSalary());
        return job;
    }
}
