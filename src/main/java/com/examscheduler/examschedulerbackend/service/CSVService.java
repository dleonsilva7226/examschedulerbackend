package com.examscheduler.examschedulerbackend.service;
import com.examscheduler.examschedulerbackend.model.Course;
import com.examscheduler.examschedulerbackend.repo.CourseRepo;
import org.springframework.stereotype.Service;
import java.io.*;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CSVService {

    private final CourseRepo myCourseRepo;

    //saves data to database. figure out how to incorporate both schedule data and course data so it isn't restrictive
    public void saveDataToDatabase(String[] data) {
        Course newCourse = new Course();
        String courseSubject = data[0];
        String courseNumber = data[1];
        String courseSection = data[2];
        String courseDays = data[3];
        String courseTime = data[4];

        newCourse.setSubject(courseSubject);
        newCourse.setNumber(Integer.parseInt(courseNumber));
        newCourse.setSection(courseSection);
        newCourse.setDays(courseDays);
        newCourse.setTime(courseTime);

        myCourseRepo.save(newCourse);

    }

    public void parseAndInsertCSV(File csvFile) {
        //adds stuff to database
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
          String line;
          line = reader.readLine();
          while (line != null) {
              String[] result = line.split(",");
              saveDataToDatabase(result);
              line = reader.readLine();
          }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

}
