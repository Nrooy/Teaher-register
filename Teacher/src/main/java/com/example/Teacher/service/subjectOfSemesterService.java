package com.example.Teacher.service;

import com.example.Teacher.entities.SubjectOfSemester;

import java.util.List;

public interface subjectOfSemesterService {
    public List<SubjectOfSemester> findAllSos(int id);

    public List<SubjectOfSemester> finfAllSosByIdSubject(int id);
}
