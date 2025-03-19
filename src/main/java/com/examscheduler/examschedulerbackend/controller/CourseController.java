package com.examscheduler.examschedulerbackend.controller;

import com.examscheduler.examschedulerbackend.model.Course;
import com.examscheduler.examschedulerbackend.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//imports data structures here
import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {
    private final CourseService service;

    @GetMapping("/findAll")
    public List<Course> findAll() {
        return new ArrayList<Course>(); // placeholder value. implement in the foreseeable future
    }

    @PostMapping("/allCourses")
    public void addCourses() {
        System.out.println("assignment");
        service.updateCoursesMonthly();
    }





}
