package com.reactive.programming.streamChaining.beans;

import java.util.Date;
import java.util.List;

public class Employee {
    private int employeeId;
    private String firstName;
    private String surname;
    private Date dateOfBirth;
    private double salary;
    private List<Project> projectsWorkingOn;

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", salary=" + salary +
                ", projectsWorkingOn=" + projectsWorkingOn +
                '}';
    }

    public Employee(int employeeId, String firstName, String surname, Date dateOfBirth, double salary, List<Project> projectsWorkingOn) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.salary = salary;
        this.projectsWorkingOn = projectsWorkingOn;
    }

    public Employee() {
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<Project> getProjectsWorkingOn() {
        return projectsWorkingOn;
    }

    public void setProjectsWorkingOn(List<Project> projectsWorkingOn) {
        this.projectsWorkingOn = projectsWorkingOn;
    }
}
