package com.empresa.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "st_id")
    private Long id;

    @Column(name = "st_name")
    private String name;

    @Column(name = "st_last_name")
    private String lastName;

    @Column(name = "st_age")
    private Integer age;

    @Column(name = "st_state")
    private Boolean state;

    public Student() {
        // Constructor o Data Transform to Jackson
    }

    public Student(Long id, String name, String lastName, Integer age, Boolean state) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}
