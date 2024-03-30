package com.example.Teacher.service.Impl;
import com.example.Teacher.service.*;
import com.example.Teacher.respository.*;
import com.example.Teacher.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class weekServiceImpl implements weekService{
    @Autowired
    weekRepository weekRepository;

    @Override
    public List<Week> getAllByIdSchdule(int id) {
        return weekRepository.getAllByIdSchedule(id);
    }
}
