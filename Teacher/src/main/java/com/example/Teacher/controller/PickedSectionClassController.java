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
//    @GetMapping("/save_picked/{id}")
//    public String savePiked(@PathVariable Integer id , HttpSession session , ModelMap modelMap){
//        PickedSectionClass pickedSectionClass = new PickedSectionClass();
//
//        pickedSectionClass.setTeacher((Teacher) session.getAttribute("teacher"));
//        pickedSectionClass.setPickedTime(Time.valueOf(LocalTime.now()));
//        pickedSectionClass.setIsPicked(1);
//        pickedSectionClass.setSectionClass(sectionClassService.findById(id));
//
//        pickedSectionClassService.save(pickedSectionClass);
//
//        List<PickedSectionClass> pickedSectionClasses = pickedSectionClassService.getAllbyId(((Teacher)session.getAttribute("teacher")).getId());
//        modelMap.addAttribute("listPicked",pickedSectionClasses);
//        return "redirect:/home1";
//    }
    @GetMapping("/home1")
    public String returnHome(HttpSession session , ModelMap modelMap){
        List<Semester> semesters = semesterService.getAllSemester();
        modelMap.addAttribute("listSemester",semesters);
        List<PickedSectionClass> pickedSectionClasses = pickedSectionClassService.getAllbyId(((Teacher)session.getAttribute("teacher")).getId());
        modelMap.addAttribute("listPicked",pickedSectionClasses);

        List <Subject> subjectList = getListSubject(pickedSectionClasses);
        int total = total(subjectList);
        modelMap.addAttribute("total",total);
        return "home";
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
