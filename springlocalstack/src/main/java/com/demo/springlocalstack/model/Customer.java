package com.demo.springlocalstack.model;

import java.time.LocalDate;

public class Customer {
    private String name;

    private String address;

    private Integer age;

    private LocalDate joinDate;

    private String gender;

    private String occupation;

    private final String FORMAT = """
                        {
              "name": "%s",
              "address": "%s",
              "age": %d,
              "join_date": "%s",
              "gender": "%s",
              "occupation": "%s"
            }
                        """;

    public Customer() {

    }

    public Customer(String name, String address, Integer age, LocalDate joinDate, String gender, String occupation) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.joinDate = joinDate;
        this.gender = gender;
        this.occupation = occupation;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Integer getAge() {
        return age;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public String getGender() {
        return gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Override
    public String toString() {
        return String.format(FORMAT, name, address, age, joinDate.toString(), gender, occupation);
    }

}
