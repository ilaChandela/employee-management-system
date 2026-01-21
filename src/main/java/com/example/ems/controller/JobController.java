package com.example.ems.controller;

import com.example.ems.dto.JobRequestDto;
import com.example.ems.dto.JobResponseDto;
import com.example.ems.entity.Job;
import com.example.ems.service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public JobResponseDto createJob(@RequestBody JobRequestDto dto) {
        return jobService.createJob(dto);
    }

    @GetMapping
    public List<JobResponseDto> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("/{id}")
    public JobResponseDto getJobById(@PathVariable Long id) {
        return jobService.getJobById(id);
    }

//    @PostMapping
//    public Job createJob(@RequestBody Job job) {
//        return jobService.createJob(job);
//    }
//
//    @GetMapping
//    public List<Job> getAllJobs() {
//        return jobService.getAllJobs();
//    }
//
//    @GetMapping("/{id}")
//    public Job getJobById(@PathVariable Long id) {
//        return jobService.getJobById(id);
//    }
}

