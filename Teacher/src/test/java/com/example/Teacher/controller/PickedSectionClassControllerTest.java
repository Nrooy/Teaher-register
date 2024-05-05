package com.example.Teacher.controller;

import com.example.Teacher.controller.PickedSectionClassController;
import com.example.Teacher.entities.*;
import com.example.Teacher.service.*;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class PickedSectionClassControllerTest {

    @Mock
    private pickedSectionClassService pickedSectionClassService;

    @Mock
    private teacherService teacherService;

    @Mock
    private staffService staffService;

    @Mock
    private subjectService subjectService;

    @InjectMocks
    private PickedSectionClassController controller;

    @Mock
    private HttpSession session;

    @Mock
    private ModelMap modelMap;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testReturnHome() {
        Member member = new Member();
        member.setId(1);

        Staff staff = new Staff();
        staff.setIdMenber(1);

        Teacher teacher = new Teacher();
        teacher.setDepartment(new Department());

        List<Subject> subjectList = new ArrayList<>();
        List<PickedSectionClass> pickedSectionClasses = new ArrayList<>();

        when(session.getAttribute("member")).thenReturn(member);
        when(staffService.findStaff(anyInt())).thenReturn(staff);
        when(teacherService.findTeacher(anyInt())).thenReturn(teacher);
        when(subjectService.getAll(anyInt())).thenReturn(subjectList);
        when(pickedSectionClassService.getAllByIdDepartment(anyInt())).thenReturn(pickedSectionClasses);

        String result = controller.returnHome(session, modelMap);

        assertEquals("register_schedule", result);
        verify(session).setAttribute("teacher", teacher);
        verify(modelMap).addAttribute("listSubject", subjectList);
        verify(modelMap).addAttribute("listPicked", pickedSectionClasses);
        verify(session).removeAttribute("error1");
    }

    @Test
    public void testDeletePicked_PickedSectionClassReviewIsOne() {
        Integer id = 1;
        PickedSectionClass pickedSectionClass = new PickedSectionClass();
        pickedSectionClass.setReview(1);

        when(pickedSectionClassService.findById(id)).thenReturn(pickedSectionClass);

        String result = controller.deletePicked(id, modelMap, session);

        assertEquals("redirect:/home1", result);
        verify(session).setAttribute("error1", "Học phần đã được phê duyệt , Không thể xóa");
        verify(pickedSectionClassService, never()).deleteById(id);
    }

    @Test
    public void testDeletePicked_PickedSectionClassReviewIsNotOne() {
        Integer id = 1;
        PickedSectionClass pickedSectionClass = new PickedSectionClass();
        pickedSectionClass.setReview(0);

        when(pickedSectionClassService.findById(id)).thenReturn(pickedSectionClass);

        String result = controller.deletePicked(id, modelMap, session);

        assertEquals("redirect:/home1", result);
        verify(pickedSectionClassService).deleteById(id);
    }

    @Test
    public void testSaveListPickedSectionClass_EmptyIdPickeds() {
        String idPickedsString = "";
        when(modelMap.addAttribute(eq("error"), anyString())).thenReturn(null);

        String result = controller.SaveListPickedSectionClass(idPickedsString, modelMap, session);

        assertEquals("review", result);
        verify(modelMap).addAttribute("error", "Chọn 1 Lớp học phần để lưu");
        verify(pickedSectionClassService, never()).findById(anyInt());
    }

}
