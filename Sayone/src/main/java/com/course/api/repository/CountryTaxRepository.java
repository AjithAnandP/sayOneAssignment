package com.course.api.repository;

import com.course.api.model.CountryTax;
import com.course.api.model.Course;
import com.course.api.model.Subscription;
import com.course.api.model.Tax;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CountryTaxRepository extends CrudRepository<CountryTax, Integer>, JpaSpecificationExecutor {

    @Query("Select ct.tax_id FROM CountryTax ct where ct.country_id.country_code = :country_code")
    public Tax getTaxByCountryId(@Param("country_code") String country_code);


}
