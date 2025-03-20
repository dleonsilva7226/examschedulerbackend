package com.examscheduler.examschedulerbackend.service;
import com.examscheduler.examschedulerbackend.model.Course;
import com.examscheduler.examschedulerbackend.repo.CourseRepo;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//database connection works
@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepo courseRepo;
    private final CSVService csvService;

    public void updateCoursesMonthly()  {
        File courseFile = new File("/Users/dan/repos/ColgateExamScheduler/courses.csv");
        csvService.parseAndInsertCSV(courseFile, true);
    }

    public List<Course> findCourse(Optional<String> courseSubjectCode, Optional<String> courseNumberCode, Optional<String> courseSectionCode) {
        if (courseSubjectCode.isPresent() && courseNumberCode.isPresent() && courseSectionCode.isPresent()) {
            return courseRepo.findBySubjectAndNumberAndSection(courseSubjectCode.get(), courseNumberCode.get(), courseSectionCode.get());
        } else if (courseSubjectCode.isPresent() && courseNumberCode.isPresent()) {
            return courseRepo.findBySubjectAndNumber(courseSubjectCode.get(), courseNumberCode.get());
        } else if (courseSubjectCode.isPresent()) {
            return courseRepo.findBySubject(courseSubjectCode.get());
        } else {
            List<Course> defaultCourseList = new ArrayList<Course>();
            Course defaultCourse = new Course(); //course object created for courses that are not found
            defaultCourse.setDays("No Days");
            defaultCourse.setNumber("No Number");
            defaultCourse.setSection("No Sections");
            defaultCourse.setSubject("No Subject Code");
            defaultCourse.setTime("No Time");
            defaultCourseList.add(defaultCourse);
            return defaultCourseList;
        }
    }




}
