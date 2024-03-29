package com.example.Teacher.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.Teacher.respository.*;
import com.example.Teacher.entities.*;
import com.example.Teacher.service.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("")
public class MemberController {
    @Autowired
    private memberService memberService;
    @Autowired
    private teacherService teacherService;
    @Autowired
    private staffService staffService;
    @Autowired
    private semesterService semesterService;
    @Autowired
    private pickedSectionClassService pickedSectionClassService;
    @GetMapping("/login")
    public String login(){
        return "login-form";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("member");
        return "redirect:/login";
    }
    @PostMapping("/home")
    public String checkLogin(HttpSession session, ModelMap modelMap, @RequestParam (name = "username") String username,
                             @RequestParam(name = "password") String password){
        Member member = new Member();
        member = memberService.checkLogin(username,password);
        if(member!= null){
            session.setAttribute("member",member);

            Teacher teacher = new Teacher();
            Staff staff = new Staff();
            staff = staffService.findStaff(member.getId());
            teacher = teacherService.findTeacher(staff.getIdMenber());

            List<Semester> semesters = semesterService.getAllSemester();
            List<PickedSectionClass> pickedSectionClasses = pickedSectionClassService.getAllbyId(staff.getIdMenber());
            modelMap.addAttribute("listSemester",semesters);
            modelMap.addAttribute("listPicked",pickedSectionClasses);
            session.setAttribute("teacher",teacher);
            return "home";
        }else {
            modelMap.addAttribute("error","Tai khoan mat khau khong chinh xac");
            return "login-form";
        }
    }
}
