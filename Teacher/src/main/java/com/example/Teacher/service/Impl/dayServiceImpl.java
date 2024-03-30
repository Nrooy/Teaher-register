package com.example.Teacher.service.Impl;
import com.example.Teacher.service.*;
import com.example.Teacher.respository.*;
import com.example.Teacher.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class dayServiceImpl implements dayService{
    @Autowired
    dayRepository dayRepository;
    @Override
    public List<day> getAllByIdSchedule(int id) {
        return dayRepository.getAllByIdSchedule(id);
    }
}
