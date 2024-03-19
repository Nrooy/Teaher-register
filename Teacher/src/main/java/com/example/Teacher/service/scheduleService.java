package com.example.Teacher.service;

import com.example.Teacher.entities.Schedule;

import java.util.List;

public interface scheduleService {
    public List <Schedule> getAll();

    public List <Schedule> getScheduleByIdSectionClass(int idSectionClass);
}
