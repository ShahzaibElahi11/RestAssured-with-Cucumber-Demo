package com.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public class Employee {
    @JsonProperty("employee_name")
    private String name;

    @JsonProperty("employee_salary")
    private int salary;

    @JsonProperty("employee_age")
    private int age;

    @JsonProperty("profile_image")
    private String image;
}
