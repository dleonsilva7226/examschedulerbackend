package com.examscheduler.examschedulerbackend.controller;

import com.examscheduler.examschedulerbackend.model.Course;
import com.examscheduler.examschedulerbackend.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/search")
    @ResponseBody
    public List<Course> findCourse(@RequestParam Optional<String> courseSubjectCode, @RequestParam Optional<String> courseNumber, @RequestParam Optional<String> courseSectionCode) {
        return service.findCourse(courseSubjectCode, courseNumber, courseSectionCode); //returns the courses associated with the search parameter
    }





}
