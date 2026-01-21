package com.example.ems.service;

import com.example.ems.dto.JobRequestDto;
import com.example.ems.dto.JobResponseDto;
import com.example.ems.entity.Job;

import java.util.List;

public interface JobService {

    JobResponseDto createJob(JobRequestDto dto);

    List<JobResponseDto> getAllJobs();

    JobResponseDto getJobById(Long id);
}
