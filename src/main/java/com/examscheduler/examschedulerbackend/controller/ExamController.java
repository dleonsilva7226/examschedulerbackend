package com.examscheduler.examschedulerbackend.controller;

import com.examscheduler.examschedulerbackend.model.Course;
import com.examscheduler.examschedulerbackend.model.Schedule;
import com.examscheduler.examschedulerbackend.service.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import com.examscheduler.examschedulerbackend.model.Schedule;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/examSchedule")
public class ExamController {

    private final ExamService service;

    @GetMapping("/findAll")
    public List<Schedule> findAll() {
        return new ArrayList<Schedule>(); // placeholder value. implement in the foreseeable future
    }

    @PostMapping("/allExamSchedules")
    public void addCourses() {
        service.updateExamScheduleMonthly();
    }
}
