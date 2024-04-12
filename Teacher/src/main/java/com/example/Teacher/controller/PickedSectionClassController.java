package com.example.Teacher.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.Teacher.service.*;
import com.example.Teacher.respository.*;
import com.example.Teacher.entities.*;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("")
public class PickedSectionClassController {
    @Autowired
    pickedSectionClassService pickedSectionClassService;
    @Autowired
    sectionClassService sectionClassService;
    @Autowired
    semesterService semesterService;
    @Autowired
    scheduleService scheduleService;

    @Autowired
    private teacherService teacherService;
    @Autowired
    private staffService staffService;

    @Autowired
    private subjectService subjectService;

    @GetMapping("/home1")
    public String returnHome(HttpSession session , ModelMap modelMap){

        Member member = (Member) session.getAttribute("member");

        Teacher teacher = new Teacher();
        Staff staff = new Staff();
        staff = staffService.findStaff(member.getId());
        teacher = teacherService.findTeacher(staff.getIdMenber());

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>" + teacher.getDepartment().getId());

        List<Subject> subjectList = subjectService.getAll(teacher.getDepartment().getId());
        modelMap.addAttribute("listSubject",subjectList); // gui sang list cac mon hoc
        List<PickedSectionClass> pickedSectionClasses = pickedSectionClassService.getAllbyId(staff.getIdMenber());
        modelMap.addAttribute("listPicked",pickedSectionClasses);
        session.setAttribute("teacher",teacher);
        return "register_schedule";
    }

    @GetMapping("delete/{id}")
    public String deletePicked(@PathVariable Integer id){
        pickedSectionClassService.deleteById(id);
        return "redirect:/home1";
    }

    public int total(List<Subject> subjectList){
        int total = 0;
        for(Subject s : subjectList){
            total += s.getNumberOfCredit();
        }
        return total;
    }

    public List<Subject> getListSubject (List<PickedSectionClass> listPicked){
        List <Subject> subjectList = new ArrayList<>();
        for(PickedSectionClass p : listPicked){
            Subject s = p.getSectionClass().getSubjectOfSemester().getSubject();
            subjectList.add(s);
        }
        return subjectList;
    }
}
