package com.example.Teacher.service;

import com.example.Teacher.entities.PickedSectionClass;
import com.example.Teacher.entities.SectionClass;
import com.example.Teacher.entities.Teacher;
import com.example.Teacher.respository.pickedSectionClassRepository;
import com.example.Teacher.service.Impl.pickedSectionClassServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@WebMvcTest(pickedSectionClassServiceImpl.class)
public class PickedSectionClassServiceTest {
    @Autowired
    private pickedSectionClassServiceImpl pickedSectionClassService;

    @MockBean
    private pickedSectionClassRepository pickedSectionClassRepository1;

    private PickedSectionClass pickedSectionClass1;
    private Teacher teacher;
    private SectionClass sectionClass;
    private List<PickedSectionClass> pickedSectionClassList;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        teacher = new Teacher();
        teacher.setId(1);
        sectionClass = new SectionClass();
        sectionClass.setId(2);
        pickedSectionClass1 = new PickedSectionClass(1, new Date(), 1, 0, "ABC123", teacher, sectionClass);

        pickedSectionClassList = new ArrayList<>();
        pickedSectionClassList.add(pickedSectionClass1);
    }

    @Test
    public void testSave_ShouldSavePickedSectionClass() {
        pickedSectionClassService.save(pickedSectionClass1);

        verify(pickedSectionClassRepository1).save(pickedSectionClass1);
    }

    @Test
    public void testGetAllById_ShouldReturnPickedSectionClassesForTeacher() {
        int teacherId = teacher.getId();

        when(pickedSectionClassRepository1.getById(teacherId)).thenReturn(pickedSectionClassList);

        List<PickedSectionClass> retrievedPickedSectionClasses = pickedSectionClassService.getAllbyId(teacherId);

        assertEquals(pickedSectionClassList, retrievedPickedSectionClasses, "Retrieved picked section classes should match expected list");
    }

    @Test
    public void testGetAllById_ShouldReturnEmptyListForNoPickedSectionClasses() {
        int teacherId = 2;

        when(pickedSectionClassRepository1.getById(teacherId)).thenReturn(Collections.emptyList());

        List<PickedSectionClass> retrievedPickedSectionClasses = pickedSectionClassService.getAllbyId(teacherId);

        assertEquals(Collections.emptyList(), retrievedPickedSectionClasses, "Should return empty list for no picked section classes");
    }

    @Test
    public void testDeleteById_ShouldDeletePickedSectionClass() {
        int id = pickedSectionClass1.getId();

        pickedSectionClassService.deleteById(id);

        verify(pickedSectionClassRepository1).deleteById(id);
    }

    @Test
    public void testGetAllByIdDepartment_ShouldReturnPickedSectionClassesForDepartment() {
        int departmentId = 1;

        when(pickedSectionClassRepository1.getAllByIdDepartment(departmentId)).thenReturn(pickedSectionClassList);

        List<PickedSectionClass> retrievedPickedSectionClasses = pickedSectionClassService.getAllByIdDepartment(departmentId);

        assertEquals(pickedSectionClassList, retrievedPickedSectionClasses, "Retrieved picked section classes should match expected list");
    }

    @Test
    public void testGetAllByIdDepartment_ShouldReturnEmptyListForNoPickedSectionClasses() {
        int departmentId = 2;

        when(pickedSectionClassRepository1.getAllByIdDepartment(departmentId)).thenReturn(Collections.emptyList());

        List<PickedSectionClass> retrievedPickedSectionClasses = pickedSectionClassService.getAllByIdDepartment(departmentId);

        assertEquals(Collections.emptyList(), retrievedPickedSectionClasses, "Should return empty list for no picked section classes");
    }

    @Test
    public void testFindById_ShouldReturnPickedSectionClass() {
        int id = pickedSectionClass1.getId();
        when(pickedSectionClassRepository1.findById(id)).thenReturn(Optional.of(pickedSectionClass1));

        PickedSectionClass retrievePickedSectionClasses = pickedSectionClassService.findById(id);

        assertEquals(pickedSectionClass1, retrievePickedSectionClasses, "Should return pickedSectionClass");
    }
}
