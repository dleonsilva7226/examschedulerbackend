package com.examscheduler.examschedulerbackend.service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.*;

@Service
@RequiredArgsConstructor
public class ExamService {

    private final CSVService csvService;

    public void updateExamScheduleMonthly()  {
        File examScheduleFile = new File("/Users/dan/repos/ColgateExamScheduler/exam_schedule.csv");
        csvService.parseAndInsertCSV(examScheduleFile, false);
    }

}
