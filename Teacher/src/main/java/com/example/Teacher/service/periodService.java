package com.example.Teacher.service;

import com.example.Teacher.entities.Period;

import java.util.List;

public interface periodService {
    public List<Period> getAllByIdSchedule(int id);
}
