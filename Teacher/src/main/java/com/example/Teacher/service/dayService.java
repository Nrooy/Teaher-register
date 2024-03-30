package com.example.Teacher.service;

import com.example.Teacher.entities.day;

import java.util.List;

public interface dayService {
    public List<day> getAllByIdSchedule(int id);
}
