package com.course.api.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "subscription")
@Getter
@Setter
@ToString
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subscription_id")
    private int subscription_id;

    @Column(name = "subscription_type")
    private String subscription_type;

    @Column(name = "subscription_duration")
    private String subscription_duration;



}