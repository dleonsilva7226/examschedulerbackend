package com.examscheduler.examschedulerbackend.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name="CALENDAR_INFO", schema="PUBLIC")
public class Calendar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //setters and getters below here
    @Column(name="STUDENT_ID", nullable = false, unique=true)
    private long studentID;

    @Column(name="EXAM_ID", nullable = false, unique=true)
    private long examID;


}
