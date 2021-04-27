package com.example.batool_assignment_2.model;

public class Information {
    private  String firstName;
    private  String lastName;
    private String address;
    private  String gender;
    private boolean isStudent;
    private String city;
    private String education;
    private String workExp;
    private String Skills;

    public Information() {
    }

    public Information(String firstName, String lastName, String address, String gender, boolean isStudent, String city, String education, String workExp, String skills) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.gender = gender;
        this.isStudent = isStudent;
        this.city = city;
        this.education = education;
        this.workExp = workExp;
        Skills = skills;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isStudent() {
        return isStudent;
    }

    public void setStudent(boolean student) {
        isStudent = student;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getWorkExp() {
        return workExp;
    }

    public void setWorkExp(String workExp) {
        this.workExp = workExp;
    }

    public String getSkills() {
        return Skills;
    }

    public void setSkills(String skills) {
        Skills = skills;
    }

    @Override
    public String toString() {
        return "Information{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", isStudent=" + isStudent +
                ", city='" + city + '\'' +
                ", education='" + education + '\'' +
                ", workExp='" + workExp + '\'' +
                ", Skills='" + Skills + '\'' +
                '}';
    }
}
