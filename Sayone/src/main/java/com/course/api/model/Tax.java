package com.course.api.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "tax")
@Getter
@Setter
@ToString
public class Tax {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tax_id")
    private int tax_id;

    @Column(name = "tax_code")
    private String tax_code;

    @Column(name = "tax_value")
    private float tax_value;

}