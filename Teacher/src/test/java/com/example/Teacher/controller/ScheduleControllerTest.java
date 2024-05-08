package com.example.Teacher.controller;

import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.example.Teacher.service.*;
import com.example.Teacher.entities.*;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@WebMvcTest(ScheduleController.class)
public class ScheduleControllerTest {
    @MockBean
    pickedSectionClassService pickedSectionClassService;
    @MockBean
    scheduleService scheduleService;
    @MockBean
    teacherService teacherService;
    @Autowired
    private ScheduleController scheduleController;
    @MockBean
    private HttpSession session;

    @MockBean
    private ModelMap modelMap;

    @MockBean
    private Member member;

    @MockBean
    private Teacher teacher;

    @MockBean
    private Subject subject;

    @Autowired
    private ScheduleController yourController;
    @Test
    public void testGetListPickedSectionClassByIdTeacher() {
        List<PickedSectionClass> list = new ArrayList<>();

        when(pickedSectionClassService.getAllbyId(3)).thenReturn(list);

        List<PickedSectionClass> result = scheduleController.GetListPickedSectionClassByIdTeacher(3);
        assertEquals(list, result);
    }
    @Test
    public void testGetListSectionClassByListPickedSectionClass() {
        // Tạo mock objects cho PickedSectionClass và SectionClass
        PickedSectionClass pickedSectionClass1 = Mockito.mock(PickedSectionClass.class);
        PickedSectionClass pickedSectionClass2 = Mockito.mock(PickedSectionClass.class);

        SectionClass sectionClass1 = Mockito.mock(SectionClass.class);
        SectionClass sectionClass2 = Mockito.mock(SectionClass.class);

        // Cấu hình behavior cho mocked objects
        when(pickedSectionClass1.getSectionClass()).thenReturn(sectionClass1);
        when(pickedSectionClass2.getSectionClass()).thenReturn(sectionClass2);

        // Tạo danh sách giả định
        List<PickedSectionClass> list = new ArrayList<>();
        list.add(pickedSectionClass1);
        list.add(pickedSectionClass2);

        // Gọi phương thức cần kiểm tra từ controller
        ScheduleController controller = new ScheduleController();
        List<SectionClass> result = controller.getListSectionClassByListPickedSectionClass(list);

        // Kiểm tra kết quả trả về từ controller
        assertEquals(2, result.size());
        assertEquals(sectionClass1, result.get(0));
        assertEquals(sectionClass2, result.get(1));
    }
    @Test
    public void testGetAllListScheduleByListSectionClass() {
        // Tạo mock objects cho SectionClass và ScheduleService
        SectionClass sectionClass1 = Mockito.mock(SectionClass.class);
        SectionClass sectionClass2 = Mockito.mock(SectionClass.class);


        // Tạo danh sách giả định cho sectionClassList
        List<SectionClass> sectionClassList = new ArrayList<>();
        sectionClassList.add(sectionClass1);
        sectionClassList.add(sectionClass2);

        // Tạo danh sách giả định cho kết quả từ scheduleService
        List<Schedule> scheduleList1 = new ArrayList<>();
        scheduleList1.add(new Schedule());

        List<Schedule> scheduleList2 = new ArrayList<>();
        scheduleList2.add(new Schedule());

        // Cấu hình behavior cho scheduleService
        when(scheduleService.getScheduleByIdSectionClass(sectionClass1.getId())).thenReturn(scheduleList1);
        when(scheduleService.getScheduleByIdSectionClass(sectionClass2.getId())).thenReturn(scheduleList2);

        // Gọi phương thức cần kiểm tra từ controller
        List<Schedule> result = scheduleController.getALlListScheduleByListSectionClass(sectionClassList);

        // Kiểm tra kết quả trả về từ controller
        assertEquals(2, result.size());
        // Kiểm tra xem danh sách kết quả có chứa các Schedule như mong đợi không
        assertTrue(result.contains(scheduleList1.get(0)));
        assertTrue(result.contains(scheduleList2.get(0)));
    }
    @Test
    public void testGetScheduleByIdSectionClass() {

        // Tạo danh sách giả định cho kết quả từ scheduleService
        List<Schedule> scheduleList = new ArrayList<>();
        scheduleList.add(new Schedule(/* Thêm thông tin về Schedule ở đây */));

        // Cấu hình behavior cho scheduleService
        when(scheduleService.getScheduleByIdSectionClass(anyInt())).thenReturn(scheduleList);

        // Gọi phương thức cần kiểm tra từ ScheduleService
        List<Schedule> results = scheduleService.getScheduleByIdSectionClass(1);
        Schedule result = results.get(0);

        // Kiểm tra kết quả trả về từ ScheduleService
        assertNotNull(result);
        // Kiểm tra xem kết quả có là một đối tượng Schedule không
        assertTrue(result instanceof Schedule);
    }
    @Test
    public void testControllerGetAllScheduleByIdSos() {
        Integer id = 1;
        Member member = new Member();
        member.setId(1);
        MockHttpSession mockHttpSession = new MockHttpSession();
        mockHttpSession.setAttribute("member", member);
        when(session.getAttribute("member")).thenReturn(member);

        when(teacherService.findTeacher(member.getId())).thenReturn(new Teacher());

        // Tạo một mock object cho lớp Schedule và cấu hình nó
        Schedule schedule =Mockito.mock(Schedule.class);
        when(scheduleService.findById(anyInt())).thenReturn(schedule);
        when(schedule.getDay()).thenReturn(new day()); // Giả sử day đã được cấu hình và trả về một đối tượng Day hợp lệ
        when(schedule.getPeriod()).thenReturn(new Period()); // Giả sử period đã được cấu hình và trả về một đối tượng Period hợp lệ

        Subject subject = Mockito.mock(Subject.class);
        when(session.getAttribute("subject")).thenReturn(subject);

        when(pickedSectionClassService.getAllbyId(anyInt())).thenReturn(List.of(new PickedSectionClass()));

        // Act
        String result = yourController.getAllScheduleByIdSos(id, mockHttpSession, modelMap);

        // Assert
        assertEquals("redirect:/subject/" + subject.getId(), result);
        verify(pickedSectionClassService, atLeast(1)).getAllbyId(anyInt());
        verify(modelMap).addAttribute(eq("listPicked"), anyList());
    }

}
