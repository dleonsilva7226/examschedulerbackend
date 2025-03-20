package com.examscheduler.examschedulerbackend.repo;

import com.examscheduler.examschedulerbackend.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long>{
    List<Course> findBySubject(String subject);
    List<Course> findBySubjectAndNumber(String subject, String number);
    List<Course> findBySubjectAndNumberAndSection(String subject, String number, String section);
}