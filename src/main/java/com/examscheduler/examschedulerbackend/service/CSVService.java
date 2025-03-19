package com.examscheduler.examschedulerbackend.service;
import com.examscheduler.examschedulerbackend.model.Course;
import com.examscheduler.examschedulerbackend.model.Schedule;
import com.examscheduler.examschedulerbackend.repo.CourseRepo;
import com.examscheduler.examschedulerbackend.repo.ScheduleRepo;
import org.springframework.stereotype.Service;
import java.io.*;
import java.util.Arrays;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CSVService {


    // repos
    private final CourseRepo myCourseRepo;
    private final ScheduleRepo myScheduleRepo;

    //saves the course data to postgresql database
    public void saveCourseData(String[] data) {
        Course newCourse = new Course();
        if (data != null && data.length >= 5) {
            String courseSubject = data[0];
            String courseNumber = data[1];
            String courseSection = data[2];
            String courseDays = data[3];
            String courseTime = data[4];

            if (courseSubject == null || courseSubject.isEmpty()
                    || courseNumber == null || courseNumber.isEmpty()
                    || courseSection == null || courseSection.isEmpty()
                    || courseDays == null || courseDays.isEmpty()
                    || courseTime == null || courseTime.isEmpty()) {
                System.out.println("Invalid piece of data");
            } else {
                newCourse.setSubject(courseSubject);
                newCourse.setNumber(courseNumber);
                newCourse.setSection(courseSection);
                newCourse.setDays(courseDays);
                newCourse.setTime(courseTime);
                myCourseRepo.save(newCourse); //find a way to have it so that CSV Data is only added once
            }
        } else {
            System.out.println("Invalid input data array");
        }
    }

    //saves the exam schedule data to postgresql database
    public void saveScheduleData(String[] data) {
        Schedule newSchedule = new Schedule();
        if (data != null && data.length >= 3) {
            String examDate = data[0];
            String examTime = data[1];
            String coursesWithExam = data[2];
            System.out.println(Arrays.toString(data));
            if (examDate == null || examDate.isEmpty()
                    || examTime == null || examTime.isEmpty()
                    || coursesWithExam == null || coursesWithExam.isEmpty()
            ) {
                System.out.println("Invalid piece of data");
            } else {
                newSchedule.setExamTime(examTime);
                newSchedule.setExamDate(examDate);
                newSchedule.setCourseTime(coursesWithExam);
                myScheduleRepo.save(newSchedule); //find a way to have it so that CSV Data is only added once
            }
        } else {
            System.out.println("Invalid input data array");
        }
    }

    // gets a csv line, parses through it and then saves it to database if a valid line
    // ex: one in which all of the parameters exist
    public void saveDataToDatabase(String[] data, boolean isCourseCSV) {
        if (isCourseCSV) {
            saveCourseData(data);
        } else {
            saveScheduleData(data);
        }

    }

    //parses through each line of the csv file received and passes it to saveData
    public void parseAndInsertCSV(File csvFile, boolean isCourseCSV) {
        //adds each line to database if valid through call to
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
          String line;
          line = reader.readLine();
          while (line != null) {
              String[] result = line.split(",");
              saveDataToDatabase(result, isCourseCSV);
              line = reader.readLine();
          }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

}
