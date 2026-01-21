package com.example.ems.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String title;

    private Double minSalary;
    private Double maxSalary;

    @OneToMany(mappedBy = "job")
    private List<Employee> employees;

    public Job() {}

    public Job(String title, Double minSalary, Double maxSalary) {
        this.title = title;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }

    // getters & setters
    public Long getId() { return id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Double getMinSalary() { return minSalary; }
    public void setMinSalary(Double minSalary) { this.minSalary = minSalary; }

    public Double getMaxSalary() { return maxSalary; }
    public void setMaxSalary(Double maxSalary) { this.maxSalary = maxSalary; }
}
