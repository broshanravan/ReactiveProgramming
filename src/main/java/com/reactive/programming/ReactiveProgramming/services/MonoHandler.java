package com.reactive.programming.ReactiveProgramming.services;

import com.reactive.programming.ReactiveProgramming.beans.Car;
import com.reactive.programming.ReactiveProgramming.inventories.CarInventory;
import reactor.core.publisher.Mono;

public class MonoHandler {
    CarInventory carInventory = new CarInventory();
    public Mono<Car> getCarById(int carId){
         Mono<Car> carMono =Mono.just(carInventory.getCarById(carId)).log();

         return carMono;
    }

    public static void main(String[] args){
        MonoHandler monoHandler = new MonoHandler();

        Mono<Car> carMono = monoHandler.getCarById(3);
        carMono.subscribe(car -> car.displayDetails());


    }
}
