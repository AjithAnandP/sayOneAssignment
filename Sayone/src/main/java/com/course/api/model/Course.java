package com.course.api.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "course")
@Getter
@Setter
@ToString
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private int course_id;

    @Column(name = "course_description")
    private String course_description;

    @Column(name = "course_name")
    private String course_name;

    @Column(name = "course_code")
    private int course_code;

    @Column(name = "net_price")
    private float net_price;



}