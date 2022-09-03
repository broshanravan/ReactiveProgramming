package com.reactive.programming.streamChaining.beans;

import java.util.Date;

public class Project {
    private int projectId;
    private String projectName;
    private Date startDate;
    private double cost;

    @Override
    public String toString() {
        return "Project{" +
                "projrctId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", startDate=" + startDate +
                ", cost=" + cost +
                '}';
    }

    public Project() {

    }

    public Project(int projrctId, String projectName, Date startDate, double cost) {
        this.projectId = projrctId;
        this.projectName = projectName;
        this.startDate = startDate;
        this.cost = cost;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
