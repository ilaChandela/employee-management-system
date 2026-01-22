package com.example.ems.service;

import com.example.ems.dto.JobRequestDto;
import com.example.ems.dto.JobResponseDto;
import com.example.ems.entity.Job;
import com.example.ems.mapper.JobMapper;
import com.example.ems.repository.JobRepository;
import com.example.ems.service.JobService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public JobResponseDto createJob(JobRequestDto dto) {
        Job job = JobMapper.toEntity(dto);
        Job saved = jobRepository.save(job);
        return JobMapper.toResponseDto(saved);
    }

    @Override
    public List<JobResponseDto> getAllJobs() {
        return jobRepository.findAll()
                .stream()
                .map(JobMapper::toResponseDto)
                .toList();
    }

    @Override
    public JobResponseDto getJobById(Long id) {
        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found"));
        return JobMapper.toResponseDto(job);
    }

//    @Override
//    public JobResponseDto createJob(JobRequestDto job) {
//        return jobRepository.save(job);
//    }
//
//    @Override
//    public List<Job> getAllJobs() {
//        return jobRepository.findAll();
//    }
//
//    @Override
//    public Job getJobById(Long id) {
//        return jobRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Job not found"));
//    }
}
