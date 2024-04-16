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

import java.util.ArrayList;
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
    private pickedSectionClassService pickedSectionClassService;
    @Autowired
    private departmentRepository departmentRepository;
    @Autowired
    private subjectService subjectService;
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

            System.out.println(">>>>>>>>>>>>>>>>>>>>>>" + teacher.getDepartment().getId());

            List<Subject> subjectList = subjectService.getAll(teacher.getDepartment().getId());
            modelMap.addAttribute("listSubject",subjectList); // gui sang list cac mon hoc


            if(teacher.getPosittion()==1){
                List<Teacher> teacherList = new ArrayList<>();
                modelMap.addAttribute("teacherList" ,teacherList);
                return "approve_schedule";
            }else {
                List<PickedSectionClass> pickedSectionClasses = pickedSectionClassService.getAllbyId(staff.getIdMenber());
                modelMap.addAttribute("listPicked",pickedSectionClasses);
                session.setAttribute("teacher",teacher);
                return "register_schedule";
            }
        }else {
            modelMap.addAttribute("error","Tai khoan mat khau khong chinh xac");
            return "login-form";
        }
    }

}
