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

        session.setAttribute("subject",subjectService.findById(id));

        List<SubjectOfSemester> subjectOfSemesters = getAllListSubjectOfSemester(id);
        List<SectionClass> sectionClassList = getAllSectionClassBySos(subjectOfSemesters);

        List<Schedule> scheduleList = new ArrayList<>();
        for(SectionClass s : sectionClassList){
            List <Schedule> list = scheduleService.getScheduleByIdSectionClass(s.getId());
            for (Schedule schedule : list) {scheduleList.add(schedule);
                break;}
        };

        modelMap.addAttribute("listSchedule",scheduleList);
        return "register";
    }
    @GetMapping("/review/subject")
    public String getAllTeacherAndSectionClass(HttpSession session,ModelMap modelMap){
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        List<PickedSectionClass> pickedSectionClasses = pickedSectionClassService.getAllByIdDepartment(teacher.getDepartment().getId());
        return "review";
    }
    public List<SubjectOfSemester> getAllListSubjectOfSemester(int IdSubject){
        List<SubjectOfSemester> list = subjectOfSemesterService.finfAllSosByIdSubject(IdSubject);
        return list;
    }
    public List<SectionClass> getAllSectionClassBySos(List<SubjectOfSemester> listSos){
        SubjectOfSemester subjectOfSemester = listSos.get(0);
        List<SectionClass> list = sectionClassService.getSectionClass(subjectOfSemester.getId());
        return list;
    }

}
