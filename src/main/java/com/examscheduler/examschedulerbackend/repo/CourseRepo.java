package com.examscheduler.examschedulerbackend.repo;

import com.examscheduler.examschedulerbackend.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course, Long>{

}