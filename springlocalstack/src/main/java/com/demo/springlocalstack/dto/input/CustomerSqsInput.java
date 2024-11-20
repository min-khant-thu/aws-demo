package com.demo.springlocalstack.dto.input;

import com.demo.springlocalstack.validator.ValidAge;

import jakarta.validation.constraints.NotEmpty;

public class CustomerSqsInput {

    @NotEmpty(message = "名前を入力してください。")
    private String name;

    @NotEmpty(message = "住所を入力してください。")
    private String address;

    @ValidAge(message = "加入できる年齢は20歳〜65歳までです。")
    private Integer age;

    @NotEmpty(message = "加入日を入力してください。")
    private String joinDate;

    @NotEmpty(message = "性別を選んでください。")
    private String gender;

    @NotEmpty(message = "職業を入力してください。")
    private String occupation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public CustomerSqsInput() {
    }

    public CustomerSqsInput(String name, String address, Integer age, String joinDate, String gender, String occupation) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.joinDate = joinDate;
        this.gender = gender;
        this.occupation = occupation;
    }
    
}
