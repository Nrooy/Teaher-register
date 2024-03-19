package com.example.Teacher.respository;

import com.example.Teacher.entities.SectionClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface sectionClassRepository extends JpaRepository<SectionClass,Integer> {
    @Query(value = "select s from SectionClass s where s.subjectOfSemester.id = :idSoS")
    List< SectionClass > getALLSectionClassByIdSos (int idSoS);
}
