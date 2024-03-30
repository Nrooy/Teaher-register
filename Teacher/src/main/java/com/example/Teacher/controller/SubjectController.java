package com.example.Teacher.controller;


import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Teacher.respository.*;
import com.example.Teacher.entities.*;
import com.example.Teacher.service.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class SubjectController {
    @Autowired
    subjectService subjectService;
    @Autowired
    private subjectOfSemesterService subjectOfSemesterService;
    @Autowired
    private pickedSectionClassService pickedSectionClassService;
    @Autowired
    private sectionClassService sectionClassService;
    // đổ tất cả moon học
    @GetMapping("/subject/")
    public String getAllSubjectByDepartment(HttpSession session, ModelMap modelMap){
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        List<Subject> subjectList = subjectService.getAll(teacher.getDepartment().getId());
        modelMap.addAttribute("listSubject",subjectList);
        return "";
    }
    // Khi click vào 1 môn học đổ tất cả cc SectionClass ra
    @GetMapping("/subject/{id}")
    public String getAllSectionCalssBySubject(HttpSession session , @PathVariable Integer id,ModelMap modelMap){
        List<SubjectOfSemester> subjectOfSemesters = getALlSubjectOfSemesterBySubject(id);
        List<SectionClass> sectionClassList=getAllSectionClassBySubjectOfSemester(subjectOfSemesters);
        modelMap.addAttribute("listSectionClass",sectionClassList);
        return "";
    }
    public List<SubjectOfSemester> getALlSubjectOfSemesterBySubject(int id){
        List<SubjectOfSemester> list = new ArrayList<>();
        list = subjectOfSemesterService.finfAllSosByIdSubject(id);
        return list;
    }
    public  List<SectionClass> getAllSectionClassBySubjectOfSemester(List<SubjectOfSemester> list){
        List <SectionClass> list1 = new ArrayList<>();
        for(SubjectOfSemester s : list){
            List <SectionClass> list2 = sectionClassService.getSectionClass(s.getId());
            for (SectionClass s1 : list2) list1.add(s1);
        }
        return  list1;
    }
}
