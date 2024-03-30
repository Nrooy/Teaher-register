package com.example.Teacher.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Teacher.service.*;
import com.example.Teacher.respository.*;
import com.example.Teacher.entities.*;

import java.util.List;

@Service
public class departmentServiceImpl implements departmentService {
    @Autowired
    departmentRepository repository;
    @Override
    public List<Department> getAllDepartment(int id) {
        return repository.getAllByIdTeacher(id);
    }
}
