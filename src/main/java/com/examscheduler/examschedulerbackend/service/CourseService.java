package com.examscheduler.examschedulerbackend.service;
import com.examscheduler.examschedulerbackend.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import com.examscheduler.examschedulerbackend.repo.CourseRepo;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.io.File;
import java.util.List;

//database connection works
@Service
@RequiredArgsConstructor
public class CourseService {

    private final CSVService csvService;

    public void updateCoursesMonthly()  {
        File courseFile = new File("/Users/dan/repos/ColgateExamScheduler/courses.csv");
        csvService.parseAndInsertCSV(courseFile, true);
    }

}
