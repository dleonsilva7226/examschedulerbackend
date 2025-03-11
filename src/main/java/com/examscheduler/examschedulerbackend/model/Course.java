package com.examscheduler.examschedulerbackend.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name="COURSE_INFO", schema="PUBLIC")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //setters and getters below here
    @Setter
    @Column(name="SUBJECT_CODE", length=4, nullable = true, unique=false)
    private String subject;

    @Setter
    @Column(name="COURSE_NUMBER", length=4, nullable = true, unique=false)
    private int number;

    @Setter
    @Column(name="SECTION_LETTER", length=2, nullable = true, unique=false)
    private String section;

    @Setter
    @Column(name="COURSE_DAYS", length=5, nullable = true, unique=false)
    private String days;

    @Setter
    @Column(name="COURSE_TIME", length=20, nullable = true, unique=false)
    private String time;

}