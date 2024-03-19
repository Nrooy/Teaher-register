package com.example.Teacher.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.example.Teacher.service.*;
import com.example.Teacher.respository.*;
import com.example.Teacher.entities.*;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("")
public class SubjectOfSemesterController {
    @Autowired
    private subjectOfSemesterService subjectOfSemesterService;

    @GetMapping("/subject-of-semester/{id}")
    public String getAllSubject(ModelMap modelMap, @PathVariable Integer id , HttpSession session){
        List<SubjectOfSemester> subjectOfSemesters = new ArrayList<>();
        subjectOfSemesters = subjectOfSemesterService.findAllSos(id);

        //Lay tat ca danh sach Subject
        Teacher teacher =(Teacher) session.getAttribute("teacher");
        int idDepartment = teacher.getDepartment().getId();

        List<Subject> listSubject = new ArrayList<>();
        for (SubjectOfSemester s :subjectOfSemesters){
            if(s.getSubject().getDepartment().getId() == idDepartment){
                listSubject.add(s.getSubject());
            }
        }
        modelMap.addAttribute("listSubject",listSubject);
        return "subject";
    }
}
