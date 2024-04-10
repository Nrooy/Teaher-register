package com.example.Teacher.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Teacher.respository.*;
import com.example.Teacher.entities.*;
import com.example.Teacher.service.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("")
public class ScheduleController {

    @Autowired
    private scheduleService scheduleService;
    @Autowired
    private pickedSectionClassService pickedSectionClassService;
    @Autowired
    private sectionClassService sectionClassService;
    @Autowired
    private teacherService teacherService;
    @GetMapping("/schedule/{id}")
    public String getAllScheduleByIdSos(@PathVariable Integer id, HttpSession session, ModelMap modelMap){
        Member member = (Member) session.getAttribute("member");
        Teacher teacher = teacherService.findTeacher(member.getId());
        List<String> stringList = ConvertListScheduleToString(teacher.getId());

        Schedule schedule = scheduleService.findById(id);
        String str = "" + schedule.getDay().getName() +schedule.getPeriod().getName();

        Boolean check = CheckDuplicateSchedule(str,stringList);
        System.out.println(check);
        return "redirect:/subject/";
    }
    public boolean CheckDuplicateSchedule(String str , List<String>list){
        for(String s : list){
            if(str.equals(list)) return false;
        }
        return  true;
    }
    public List<String> ConvertListScheduleToString(int idTeacher){
        List<PickedSectionClass> pickedSectionClassList = GetListPickedSectionClassByIdTeacher(idTeacher);
        List<SectionClass> sectionClassList = getListSectionClassByListPickedSectionClass(pickedSectionClassList);
        List<Schedule> scheduleList = getALlListScheduleByListSectionClass(sectionClassList);

        List <String> list = new ArrayList<>();
        for (Schedule s : scheduleList){
            String str = "";
            str= str+ s.getDay().getName() + s.getPeriod().getName();
            list.add(str);
        }
        return  list;
    }
    public List<PickedSectionClass> GetListPickedSectionClassByIdTeacher(int idTeacher){
        List<PickedSectionClass> list = pickedSectionClassService.getAllbyId(idTeacher);
        return list;
    }
    public List<SectionClass> getListSectionClassByListPickedSectionClass(List<PickedSectionClass>list){
        List<SectionClass> sectionClassList = new ArrayList<>();
        for(PickedSectionClass p : list){
            SectionClass s = p.getSectionClass();
            sectionClassList.add(s);
        }
        return sectionClassList;
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
