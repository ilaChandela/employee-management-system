package com.example.ems.mapper;

import com.example.ems.dto.*;
import com.example.ems.entity.*;

public class EmployeeMapper {

    public static EmployeeResponseDto toDto(Employee employee) {

        EmployeeResponseDto dto = new EmployeeResponseDto();
        dto.setId(employee.getId());
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setEmail(employee.getEmail());
        dto.setSalary(employee.getSalary());
        dto.setHireDate(employee.getHireDate());


        Department d = employee.getDepartment();
        if (d != null) {
            DepartmentResponseDto dd = new DepartmentResponseDto();
            dd.setId(d.getId());
            dd.setName(d.getName());
            dd.setLocation(d.getLocation());
            dto.setDepartment(dd);
        }

        Job j = employee.getJob();
        if (j != null) {
            JobResponseDto jd = new JobResponseDto();
            jd.setId(j.getId());
            jd.setTitle(j.getTitle());
            jd.setMinSalary(j.getMinSalary());
            jd.setMaxSalary(j.getMaxSalary());
            dto.setJob(jd);

        }

        return dto;
    }

    public static Employee toEntity(EmployeeRequestDto dto) {
        Employee employee = new Employee();
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setEmail(dto.getEmail());
        employee.setSalary(dto.getSalary());
        employee.setHireDate(dto.getHireDate());
        return employee;
    }
}
