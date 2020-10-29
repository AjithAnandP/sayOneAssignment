package com.course.api.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "course_subscription")
@Getter
@Setter
public class CourseSubscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_subscription_id")
    private int course_subscription_id;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "course_id")
    private Course course_id;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "subscription_id")
    private Subscription subscription_id;



}