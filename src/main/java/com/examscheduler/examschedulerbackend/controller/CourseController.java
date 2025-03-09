package com.examscheduler.examschedulerbackend.controller;

import com.examscheduler.examschedulerbackend.model.Course;
import com.examscheduler.examschedulerbackend.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//imports data structures here
import java.util.*;

@RestController
@RequestMapping("courses")
public class CourseController {
    @Autowired
    private ExamService service;

    @GetMapping
    public List<Course> findAll() {
        return new ArrayList<Course>(); // placeholder value
    }

    public List<String> getCourseInfo() {
        return service.parseCourseCSV();
    }
}
