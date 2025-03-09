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

    @Column(name="COURSE_NUMBER", length=4, nullable = true, unique=false)
    private int number;

    @Column(name="SECTION_LETTER", length=2, nullable = true, unique=false)
    private String section;


    @Column(name="COURSE_DAYS", length=5, nullable = true, unique=false)
    private String days;

    @Column(name="COURSE_TIME", length=20, nullable = true, unique=false)
    private String time;

    public void setNumber(int courseNumber) {
        this.number = courseNumber;
    }
    public void setSection(String courseSection) {
        this.section = courseSection;
    }

    public void setTime(String courseTime) {
        this.time = courseTime;
    }




}