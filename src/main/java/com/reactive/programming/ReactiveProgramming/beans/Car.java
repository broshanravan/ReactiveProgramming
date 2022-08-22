package com.reactive.programming.ReactiveProgramming.beans;

public record Car(int id, String make, String model, int year ) {

    public String displayDetails(){
        System.out.println("Make: " + make);
        System.out.println("Model:: " + model);
        System.out.println("Year: " + year);

        return("Make: " + make + " Model: " + model +  "Year: " + year);
    }
}
