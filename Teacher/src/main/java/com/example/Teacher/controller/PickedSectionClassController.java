package com.example.Teacher.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.example.Teacher.service.*;
import com.example.Teacher.respository.*;
import com.example.Teacher.entities.*;

import java.security.PublicKey;
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
    public String deletePicked(@PathVariable Integer id, ModelMap modelMap){
        PickedSectionClass pickedSectionClass = pickedSectionClassService.findById(id);
        if(pickedSectionClass.getReview() ==1){
            modelMap.addAttribute("error","Học phần đã được phê duyệt , Không thể xóa");
            return "redirect:/home1";
        }
        else{
            pickedSectionClassService.deleteById(id);
            return "register_schedule";
        }
    }
    @PostMapping("review/save-list-picked")
    public String SaveListPickedSectionClass(@PathVariable List<PickedSectionClass> list, ModelMap modelMap ,HttpSession session){
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        List<PickedSectionClass> pickedSectionClasses = pickedSectionClassService.getAllByIdDepartment(teacher.getDepartment().getId());

        List<Subject> subjectList = subjectService.getAll(teacher.getDepartment().getId());
        modelMap.addAttribute("listSubject",subjectList);

        modelMap.addAttribute("listPicked",pickedSectionClasses);
        if(list.isEmpty()){
            modelMap.addAttribute("error","Chọn 1 Lớp học phần để lưu");
        }else{
            SavePickedSectionClassAfterReview(list);
        }

        return "review";
    }

    public void SavePickedSectionClassAfterReview(List<PickedSectionClass>pickedSectionClasses){
        for( PickedSectionClass p : pickedSectionClasses){
            p.setReview(1);
            pickedSectionClassService.save(p);
        }
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
