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
        check = CheckDuplicate(sectionClassService.findById(id),member.getId());
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
    @GetMapping("review/section-class/{id}")
    public String chooseReviewSectionClass(HttpSession session,@PathVariable Integer id,ModelMap modelMap){
        PickedSectionClass pickedSectionClass = pickedSectionClassService.findById(id);
        Teacher teacher = pickedSectionClass.getTeacher();
        SectionClass sectionClass = pickedSectionClass.getSectionClass();
        if (CheckDuplicate(sectionClass,teacher.getId())){
            return "redirect:/review/subject";
        }
        else {
            modelMap.addAttribute("error","Không thể chọn lớp học phần đã bị trùng lịch dạy");
            return "redirect:review/section-class/" + pickedSectionClass.getId();
        }
    }

    public Boolean CheckDuplicate(SectionClass s , int IdTeacher){

        //Lấy tất cả danh sách PickedSectionClass theo Id của giáo viên
        List <PickedSectionClass> pickedSectionClasses =  pickedSectionClassService.getAllbyId(IdTeacher);

        // Từ danh sách của PickedSectionClass sẽ xuất ra Danh sách SectionClass tương ứng
        List <SectionClass> sectionClassList = new ArrayList<>();
        for(PickedSectionClass p : pickedSectionClasses){
            sectionClassList.add((SectionClass) p.getSectionClass());
        }

        // Lấy tất cả Schedule tương ứng với Danh sách SectionClass của giáo viên đăng ký
        List<Schedule> scheduleList = new ArrayList<>();
        for (SectionClass se : sectionClassList){
            List<Schedule> schedules = new ArrayList<>();
            schedules = scheduleService.getScheduleByIdSectionClass(se.getId());
            for(Schedule sc : schedules) scheduleList.add(sc);
        }

        //Lấy Schedule của SectionClass input
        List<Schedule> scheduleListInput = new ArrayList<>();
        scheduleListInput = scheduleService.getScheduleByIdSectionClass(s.getId());

        // Bắt đầu so sánh
            //Week , Period , day , của Schedule Input : scheduleListInput
                //Khai báo
        List<Week> weekList1 = new ArrayList<>();
        List<Period> periodList1 = new ArrayList<>();
        List<day> dayList1 = new ArrayList<>();
                // Lấy dữ liệu
        for(Schedule sch : scheduleList){
            //Lấy week
            List<Week> demow= weekService.getAllByIdSchdule(sch.getId());
            Week w = demow.getFirst();
            weekList1.add(w);
            //Lấy Period
            List<Period> demop = periodService.getAllByIdSchedule(sch.getId());
            Period p = demop.getFirst();
            periodList1.add(p);
            //Lấy day
            List<day> demod = dayService.getAllByIdSchedule(sch.getId());
            day d =demod.getFirst();
            dayList1.add(d);
        }
            //Week , Period , day , của Schedule
        List<Week> weekList2 = new ArrayList<>();
        List<Period> periodList2 = new ArrayList<>();
        List<day> dayList2 = new ArrayList<>();
        // Lấy dữ liệu
        for(Schedule sch : scheduleList){
            //Lấy week
            List<Week> demow= weekService.getAllByIdSchdule(sch.getId());
            Week w = demow.getFirst();
            weekList2.add(w);
            //Lấy Period
            List<Period> demop = periodService.getAllByIdSchedule(sch.getId());
            Period p = demop.getFirst();
            periodList2.add(p);
            //Lấy day
            List<day> demod = dayService.getAllByIdSchedule(sch.getId());
            day d =demod.getFirst();
            dayList2.add(d);
        }
            // So sánh
            for (day d1 : dayList1){
                for(day d2 : dayList2){
                    if(d1.equals(d2)) {
                        for (Period p1 : periodList1){
                            for(Period p2 : periodList2){
                                if(p1.equals(p2)) {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
            return true;

    }

}
