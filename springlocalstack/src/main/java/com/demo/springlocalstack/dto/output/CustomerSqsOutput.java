package com.demo.springlocalstack.dto.output;


public class CustomerSqsOutput {
    private String name;

    private String address;

    private int age;

    private String joinDate;

    private String gender;

    private String occupation;

    public CustomerSqsOutput() {

    }

    public CustomerSqsOutput(String name, String address, int age, String joinDate, String gender,
            String occupation) {
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

    public int getAge() {
        return age;
    }

    public String getJoinDate() {
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

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

}
