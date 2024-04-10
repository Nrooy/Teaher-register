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
    @Autowired
    private scheduleService scheduleService;
    @GetMapping("/subject/{id}")
    public String getAllSectionCalssBySubject(HttpSession session , @PathVariable Integer id,ModelMap modelMap){
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        List<Subject> subjectList = subjectService.getAll(teacher.getDepartment().getId());
        modelMap.addAttribute("listSubject",subjectList);

        List<SubjectOfSemester> subjectOfSemesterList = GetAllSubjectOfSemesterBySubject(id);
        System.out.println(subjectOfSemesterList.get(0).getId());
        List<SectionClass> sectionClassList = GetALLSectionClassByListSoS(subjectOfSemesterList);
        List<Schedule> scheduleList = getALlListScheduleByListSectionClass(sectionClassList);

        modelMap.addAttribute("listSchedule",scheduleList);
        return "register";
    }
    @GetMapping("/review/subject")
    public String getAllTeacherAndSectionClass(HttpSession session,ModelMap modelMap){
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        List<PickedSectionClass> pickedSectionClasses = pickedSectionClassService.getAllByIdDepartment(teacher.getDepartment().getId());
        return "review";
    }
    public List<SubjectOfSemester> GetAllSubjectOfSemesterBySubject(int id){
        List<SubjectOfSemester>subjectOfSemesterList = new ArrayList<>();
        subjectOfSemesterList = subjectOfSemesterService.finfAllSosByIdSubject(id);
        return  subjectOfSemesterList;
    }
    public List<SectionClass> GetALLSectionClassByListSoS(List<SubjectOfSemester> subjectOfSemesterList){
        List<SectionClass> sectionClassList = new ArrayList<>();
        for (SubjectOfSemester s : subjectOfSemesterList){
            List<SectionClass> list = sectionClassService.getSectionClass(s.getId());
            for(SectionClass se : list) sectionClassList.add(se);
        }
        return  sectionClassList;
    }
    public List<Schedule> getALlListScheduleByListSectionClass(List<SectionClass>sectionClassList){
        List<Schedule> scheduleList = new ArrayList<>();
        for(SectionClass s : sectionClassList){
            List<Schedule> list = scheduleService.getScheduleByIdSectionClass(s.getId());
            for(Schedule sc : list){
                scheduleList.add(sc);
                break;
            }
        }
        return scheduleList;
    }

}
