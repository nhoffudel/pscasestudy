package com.github.nhoffudel.service.studentservice;

import com.github.nhoffudel.JdbcConfigurator;
import org.junit.*;

import static org.junit.Assert.assertTrue;

/**
 * @author leonhunter
 * @created 02/12/2020 - 8:24 PM
 */ // TODO - Define tests
public class ValidateStudentTest {
    @Before
    public void setup(){
        JdbcConfigurator.initialize();
    }

    @Test
    public void test(){
        StudentService studentService = new StudentService();
        Boolean isValidLogin = studentService.validateStudent("lou", "uol");
        assertTrue(isValidLogin);
    }
}
