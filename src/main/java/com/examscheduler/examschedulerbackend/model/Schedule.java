package com.examscheduler.examschedulerbackend.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name="SCHEDULE_INFO", schema="PUBLIC")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(name="EXAM_DATE", length=40, nullable = true, unique=false)
    private String examDate;

    @Setter
    @Column(name="EXAM_TIME", length=40, nullable = true, unique=false)
    private String examTime;

    @Setter
    @Column(name="COURSE_TIME", length=40, nullable = true, unique=false)
    private String courseTime;



}