package com.example.Teacher.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.Teacher.service.*;
import com.example.Teacher.respository.*;
import com.example.Teacher.entities.*;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SectionClassController {
    @Autowired
    private sectionClassService sectionClassService;
    @Autowired
    private scheduleService scheduleService;
    @Autowired
    private pickedSectionClassService pickedSectionClassService;
    @Autowired
    private weekService weekService;
    @Autowired
    private dayService dayService;
    @Autowired
    private periodService periodService;
    @Autowired
    private teacherService teacherService;
    @GetMapping("/secion-class/{id}")
    public String SectionClass(HttpSession session , @PathVariable Integer id, ModelMap modelMap){
        List<SectionClass> sectionClasses = sectionClassService.getSectionClass(id);
        List<Schedule> schedules = scheduleService.getScheduleByIdSectionClass(id);

        modelMap.addAttribute("listSchedule",schedules);
        modelMap.addAttribute("listSectionClass",sectionClasses);
        return "section-class";
    }
    @GetMapping("/section-class/{id}")
    public String chooseSectionClass(HttpSession session ,@PathVariable Integer id , ModelMap modelMap){
        Member member = new Member();
        member = (Member) session.getAttribute("member");
        boolean check;
        check = false;
        if(check){
            PickedSectionClass pickedSectionClass = new PickedSectionClass();

            pickedSectionClass.setTeacher((Teacher) session.getAttribute("teacher"));
            pickedSectionClass.setPickedTime(Time.valueOf(LocalTime.now()));
            pickedSectionClass.setIsPicked(1);
            pickedSectionClass.setSectionClass(sectionClassService.findById(id));

            pickedSectionClassService.save(pickedSectionClass);

            List<PickedSectionClass> pickedSectionClasses = pickedSectionClassService.getAllbyId(((Teacher)session.getAttribute("teacher")).getId());
            modelMap.addAttribute("listPicked",pickedSectionClasses);
            return "";
        }else{
            modelMap.addAttribute("error","Lớp học phần đã bị trùng lịch");
            return "";
        }
    }



}
