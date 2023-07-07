package com.example.studentservice.controller;

import com.example.studentservice.request.CreateStudentRequest;
import com.example.studentservice.response.StudentResponse;
import com.example.studentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public StudentResponse creStudentResponse(@RequestBody CreateStudentRequest createStudentRequest)
    {
        return studentService.createStudent(createStudentRequest);
    }
    @GetMapping("/getById/{id}")
    public StudentResponse getById (@PathVariable long id) {
        return studentService.getById(id);
    }
}
