package com.example.Teacher.respository;

import com.example.Teacher.entities.SubjectOfSemester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface subjectOfSemesterRepository extends JpaRepository<SubjectOfSemester,Integer> {
    @Query(value = "select s from SubjectOfSemester s where s.semester.id = :id")
    List<SubjectOfSemester> findSubjectOfSemesterByIdSemester(int id);
}
