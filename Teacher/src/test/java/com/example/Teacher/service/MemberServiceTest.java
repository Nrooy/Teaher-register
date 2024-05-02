package com.example.Teacher.service;

import com.example.Teacher.entities.Member;
import com.example.Teacher.respository.memberRespository;
import com.example.Teacher.service.Impl.memberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.text.ParseException;
import java.text.SimpleDateFormat;


@WebMvcTest(memberServiceImpl.class)
public class MemberServiceTest {
    @Autowired
    private memberServiceImpl memberService;

    @MockBean
    private memberRespository respository;

    // test case trả về người dùng với tài khoản, mật khẩu khả dụng
    @Test
    public void testCheckLogin_ShouldReturnMemberForValidCredentials() throws ParseException {

        // 7 Ha Noi	1990-01-01 trinhnc@gmail.com Nguyen Chien Trinh	trinhnc	0915400946 trinhnc
        Member expectedMember = new Member();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        expectedMember.setId(7);
        expectedMember.setAddress("Ha Noi");
        expectedMember.setDateOfBirth(dateFormat.parse("1990-01-01"));
        expectedMember.setName("Nguyen Chien Trinh");
        expectedMember.setEmail("trinhnc@gmail.com");
        expectedMember.setUsername("trinhnc");
        expectedMember.setPassword("trinhnc");
        expectedMember.setPhone("0915400946");

        String username = "trinhnc";
        String password = "trinhnc";

        Mockito.when(respository.checkLogin(username, password)).thenReturn(expectedMember);

        Member retrievedMember = memberService.checkLogin("trinhnc", "trinhnc");

        Assertions.assertEquals(expectedMember, retrievedMember, "Retrieved member should match expected member");

    }

    // test case trả về null khi tài khoản, mật khẩu không khả dụng
    @Test
    public void testCheckLogin_ShouldReturnNullForInvalidCredentials() throws ParseException {
        String username = "abc";
        String password = "123";

        Member expectedMember = new Member();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        expectedMember.setId(7);
        expectedMember.setAddress("Ha Noi");
        expectedMember.setDateOfBirth(dateFormat.parse("1990-01-01"));
        expectedMember.setName("Nguyen Chien Trinh");
        expectedMember.setEmail("trinhnc@gmail.com");
        expectedMember.setUsername("trinhnc");
        expectedMember.setPassword("trinhnc");
        expectedMember.setPhone("0915400946");

        Mockito.when(respository.checkLogin(username, password)).thenReturn(null);
        Mockito.when(respository.checkLogin("trinhnc", "trinhnc")).thenReturn(expectedMember);

        Member retrievedMember = memberService.checkLogin(username, password);

        Assertions.assertEquals(null, retrievedMember, "Should return null for invalid credentials");

    }
}
