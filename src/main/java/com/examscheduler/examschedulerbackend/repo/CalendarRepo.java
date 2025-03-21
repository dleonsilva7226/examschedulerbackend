package com.examscheduler.examschedulerbackend.repo;

import com.examscheduler.examschedulerbackend.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarRepo extends JpaRepository<Course, Long>{

}