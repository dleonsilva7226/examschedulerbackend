package com.examscheduler.examschedulerbackend.service;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.io.File;


@Service
@RequiredArgsConstructor
public class CourseService {

    private CSVService csvService;

    @Scheduled(cron = "0 0 0 1 * *")
    public void updateCoursesMonthly() throws Exception {
        File courseFile = new File("/Users/dan/repos/ColgateExamScheduler/courses.csv");
        csvService.parseAndInsertCSV(courseFile);
    }
}
