package com.reactive.programming.services;

import com.reactive.programming.beans.Car;
import com.reactive.programming.inventories.CarInventory;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import java.time.Duration;
import java.util.List;
import java.util.Random;

@Slf4j
public class FluxHandler {

    CarInventory carInventory = new CarInventory();


    public Flux<Car> getAllCars(){
        List<Car> availableCars = carInventory.getAllCars();
        List carsLIst = carInventory.getAllCars();
         return Flux.fromIterable(carsLIst).log();

    }

    public Flux<Car> getAllFilteredCars(List<Integer> selectedCarIds){
        List<Car> availableCars = carInventory.getAllCars();
        return Flux.fromIterable(availableCars).filter(car ->{
            return selectedCarIds.contains(car.id());}).log();

    }

    public Flux<List<Car>> getAllCarsFilteredAndMapped(List<Integer> selectedCarIds){
        List<Car> availableCars = carInventory.getAllCars();
        return Flux.fromIterable(availableCars)
                .filter(car ->{
                    return selectedCarIds.
                    contains(car.id());}).
                    map(car -> carInventory.
                    getCarPreviousModels(car.id())).
                    log();

    }
    public Flux<List<Car>> getAllCarPreviousModels(){;
        List<Car> availableCars = carInventory.getAllCars();
        return Flux.fromIterable(availableCars)
        .map(car -> carInventory.
        getCarPreviousModels(car.id())).
        log();
    }

    public Flux<String> getFilteredFlatMapOfCarModels(List<Integer> selectedcarIds){
        List<Car> availableCars = carInventory.getAllCars();

        return Flux.fromIterable(availableCars)
                .filter(car ->{
                    return selectedcarIds.
                            contains(car.id());}).
                flatMap(car -> Flux.just(carInventory.
                        getCarById(car.id()).model())).
                log();

    }

    public Flux<String> getFlatMapOfAllCarModels(){
        //List<Car> availableCars = carInventory.getAllCars();
        return Flux.fromIterable(carInventory.getAllCars()).
                flatMap(car -> Flux.just(carInventory.
                getCarById(car.id()).model()));

    }

    public Flux<String> getFlatMapOfAllCarMakes(){
        //List<Car> availableCars = carInventory.getAllCars();
        return Flux.fromIterable(carInventory.getAllCars()).
                flatMap(car -> Flux.just(carInventory.
                        getCarById(car.id()).make()));

    }

    public Flux<String> getConcatMapOfAllCarMakes(){
        return Flux.fromIterable(carInventory.getAllCars()).
                concatMap(car -> Flux.just(carInventory.
                        getCarById(car.id()).make())).doOnError(l -> log.info("Process error"));

    }

    public Flux<String> getDelayedConcatMapOfAllCarMakes(){
        //List<Car> availableCars = carInventory.getAllCars();
        return Flux.fromIterable(carInventory.getAllCars()).
                concatMap(car -> Flux.just(carInventory.
                        getCarById(car.id()).make()).delayElements(Duration.ofMillis(
                        new Random().nextInt(10000)
                )));

    }


    public static void main(String[] args){
        FluxHandler fluxHandler = new FluxHandler();
        //fluxHandler.getAllCars().subscribe(car -> car.displayDetails());;
        //fluxHandler.getAllFilteredCars(List.of(1,4)).subscribe(car -> car.displayDetails());
        //fluxHandler.getAllCarsFilteredAndMapped(List.of(1,4)).subscribe(car -> car.displayDetails());
        //fluxHandler.getFlatMapOfAllCarModels().subscribe(System.out::println);
        //fluxHandler.getFlatMapOfAllCarMakes().subscribe(System.out::println);
        //fluxHandler.getFilteredFlatMapOfCarModels(List.of(3,2)).subscribe(System.out::println);

        //Flux<String> modelsFlux = fluxHandler.getDelayedConcatMapOfAllCarMakes();
        fluxHandler.getDelayedConcatMapOfAllCarMakes().subscribe(carMakes-> System.out.println(carMakes));

        //Flux<List<Car>> perviusModelsFlux = fluxHandler.getAllCarPreviousModels();
        //perviusModelsFlux.subscribe(carsList ->(System.out.println(carsList::get));

    }
}
