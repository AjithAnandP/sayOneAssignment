package com.course.api.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "country")
@Getter
@Setter
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private int country_id;

    @Column(name = "country_code")
    private String country_code;

    @Column(name = "country_name")
    private String country_name;
}