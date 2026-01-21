package com.example.ems.service;

import com.example.ems.dto.DepartmentRequestDto;
import com.example.ems.dto.DepartmentResponseDto;
import com.example.ems.entity.Department;
import com.example.ems.mapper.DepartmentMapper;
import com.example.ems.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }

    @Override
    public DepartmentResponseDto createDepartment(DepartmentRequestDto dto) {

        Department department = DepartmentMapper.toEntity(dto);
        Department saved = departmentRepository.save(department);
        return DepartmentMapper.toResponseDto(saved);

    }

    @Override
    public List<DepartmentResponseDto> getAllDepartments() {
        return departmentRepository.findAll()
                .stream()
                .map(DepartmentMapper::toResponseDto)
                .toList();
    }

    @Override
    public DepartmentResponseDto getDepartmentById(Long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        return DepartmentMapper.toResponseDto(department);
    }

//    @Override
//    public List<Department> getAllDepartments() {
//        return departmentRepository.findAll();
//    }
//
//    @Override
//    public Department getDepartmentById(Long id) {
//        return departmentRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Department not found"));
//    }


}
