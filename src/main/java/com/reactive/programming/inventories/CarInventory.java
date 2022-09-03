package com.reactive.programming.inventories;

import com.reactive.programming.beans.Car;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;

@Data
@Slf4j
public class CarInventory {



    Car bmw = new Car(1,"BMW", "M5",2021);
    Car audi = new Car(2,"Audi", "A5",2022);
    Car vauxhall = new Car(3,"Vaxhall", "Cavalier",2018);
    Car fiat = new Car(4,"Fiat", "Punto",2008);

    List<Car> availableCars = List.of(bmw,audi,vauxhall,fiat);


    public List<Car> getAllCars(){
        log.info("Collecting cars list from DB");
        return availableCars;
    }

    public Car getCarById(int id){
        for (Car car: availableCars){
            if(car.id() ==id)
                return car;
        }
        return bmw;
    }

    public List<Car> getCarPreviousModels(int id){

        List<Car> previousModels = new LinkedList<Car>();
        for (Car car: availableCars){
            if(id ==1) {
                previousModels.add( new Car(1,"BMW", "M4",2020));
                previousModels.add( new Car(2,"BMW", "CmM",2019));
                previousModels.add( new Car(3,"BMW", "C3",2019));
            }else if (id ==2){
                previousModels.add(new Car(4,"Audi", "A4",2019));
                previousModels.add(new Car(5,"Audi", "A3",2017));
                previousModels.add(new Car(6,"Audi", "A2",2016));
            }else if (id ==3){
                previousModels.add(new Car(7,"Vaxhall", "Astra",2016));
                previousModels.add(new Car(8,"Vaxhall", "Vectra",2017));
                previousModels.add(new Car(9,"Vaxhall", "Panda",2011));
            }else if (id ==4){
                previousModels.add(new Car(10,"Fiat", "Panda",2015));
                previousModels.add(new Car(11,"Fiat", "Panda",2014));
                previousModels.add(new Car(12,"Fiat", "Panda",2013));
            }
        }
        return previousModels;
    }

}
