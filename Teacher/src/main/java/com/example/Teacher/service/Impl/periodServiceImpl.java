package com.example.Teacher.service.Impl;
import com.example.Teacher.service.*;
import com.example.Teacher.respository.*;
import com.example.Teacher.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class periodServiceImpl implements periodService{
    @Autowired
    periodRepository repository;

    @Override
    public List<Period> getAllByIdSchedule(int id) {
        return repository.getAllByIdSchdule(id);
    }
}
