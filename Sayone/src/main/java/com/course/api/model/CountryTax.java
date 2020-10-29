package com.course.api.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "country_tax")
@Getter
@Setter
public class CountryTax {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_tax_id")
    private int country_tax_id;

    @OneToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "tax_id")
    private Tax tax_id;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "country_id")
    private Country country_id;

}