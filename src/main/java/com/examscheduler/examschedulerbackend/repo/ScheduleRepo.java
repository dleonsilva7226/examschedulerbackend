package com.examscheduler.examschedulerbackend.repo;

import com.examscheduler.examschedulerbackend.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepo extends JpaRepository<Schedule, Long>{
    
}