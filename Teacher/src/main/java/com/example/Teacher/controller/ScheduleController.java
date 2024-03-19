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
import com.example.Teacher.service.scheduleService;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("")
public class ScheduleController {

    @Autowired
    private scheduleService scheduleService;

    @GetMapping("/schedule/{id}")
    public String getAllScheduleByIdSos(@PathVariable Integer id, HttpSession session, ModelMap modelMap){
        List <Schedule> schedules = scheduleService.getAll();
        modelMap.addAttribute("listSchdule",schedules);

        List <PickedSectionClass> picked = new ArrayList<>();
        session.setAttribute("listPicked",picked);
        return "schedule";
    }
}
