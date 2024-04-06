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
    private teacherService teacherService;
    @Autowired
    private subjectService subjectService;
    @GetMapping("/section-class/{id}")
    public String chooseSectionClass(HttpSession session ,@PathVariable Integer id , ModelMap modelMap){
        Member member = new Member();
        member = (Member) session.getAttribute("member");
        Teacher teacher = teacherService.findTeacher(member.getId());
        Schedule schedule = scheduleService.findById(id);

        List <PickedSectionClass> pickedSectionClasses = GetListPickedSectionClassByTeacher(teacher);
        List <SectionClass> sectionClassList = GetListSectionClassByPickedSectionClass(pickedSectionClasses);
        List <Schedule> scheduleList = GetListScheduleBySectionClass(sectionClassList);

        String str = schedule.getDay().getName() + schedule.getPeriod().getName();
        List <String> stringList = new ArrayList<>();
        for (Schedule s : scheduleList){
            String st = "";
            st = st + s.getDay().getName() + s.getPeriod().getName();
            stringList.add(st);
        }
        modelMap.addAttribute("listPickedSectionClass",pickedSectionClasses);

        if(CheckDuplicate(str,stringList)){
            SavePickedSectionClass(schedule,teacher);
        }else{
            modelMap.addAttribute("error","Lớp học phần đã chọn bị trùng thời gian dạy");
        }
        Subject subject = (Subject) session.getAttribute("subject");
        session.removeAttribute("subject");

        return "redirect:/subject/" + subject.getId();

    }
    @GetMapping("review/section-class/{id}")
    public String chooseReviewSectionClass(HttpSession session,@PathVariable Integer id,ModelMap modelMap){
        PickedSectionClass pickedSectionClass = pickedSectionClassService.findById(id);
        Teacher teacher = pickedSectionClass.getTeacher();
        SectionClass sectionClass = pickedSectionClass.getSectionClass();
        return "";
    }
    public Boolean CheckDuplicate(String str , List <String> stringList){

        for(String s : stringList){
            if(s.equals(str)) return false;
        }
        return true;
    }
    public List<PickedSectionClass> GetListPickedSectionClassByTeacher(Teacher teacher){
        List<PickedSectionClass> pickedSectionClassList = teacher.getPickedSectionClasses();
        return pickedSectionClassList;
    }
    public List <SectionClass> GetListSectionClassByPickedSectionClass(List<PickedSectionClass> pickedSectionClassList){
        List <SectionClass> sectionClassList = new ArrayList<>();
        for(PickedSectionClass p : pickedSectionClassList){
            sectionClassList.add(p.getSectionClass());
        }
        return sectionClassList;
    }
    public List<Schedule> GetListScheduleBySectionClass(List<SectionClass>sectionClassList){
        List<Schedule> scheduleList = new ArrayList<>();
        for(SectionClass s : sectionClassList){
            List <Schedule> list = scheduleService.getScheduleByIdSectionClass(s.getId());
            for (Schedule schedule : list) {scheduleList.add(schedule);
                break;}
        };
        return  scheduleList;
    }
    public void SavePickedSectionClass(Schedule schedule , Teacher teacher){
        PickedSectionClass pickedSectionClass = new PickedSectionClass();
        pickedSectionClass.setTeacher(teacher);
        pickedSectionClass.setPickedTime(Time.valueOf(LocalTime.now()));
        pickedSectionClass.setIsPicked(1);
        pickedSectionClass.setReview(0);
        pickedSectionClass.setSectionClass(schedule.getSectionClass());

        pickedSectionClassService.save(pickedSectionClass);
    }
}
