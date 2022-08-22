package com.reactive.programming.services;

import com.reactive.programming.beans.Car;

public class RunablePrint implements Runnable
{
    private Car car;
    public RunablePrint(Car carIn){
        this.car= carIn;

    }
    @Override
    public void run() {
        car.displayDetails();

    }
}
