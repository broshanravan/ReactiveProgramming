package com.reactive.programming.services;

import com.reactive.programming.beans.Car;
import com.reactive.programming.inventories.CarInventory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import reactor.test.StepVerifier;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class FluxHandlerTest {

    static FluxHandler fluxHandler = new FluxHandler();

    static Car bmw = new Car(1,"BMW", "M5",2021);
    static Car audi = new Car(2,"Audi", "A5",2022);
    static Car vauxhall = new Car(3,"Vaxhall", "Cavalier",2018);
    static Car fiat = new Car(4,"Fiayt", "Punto",2008);

    @Mock
    static CarInventory carInventory = Mockito.mock(CarInventory.class);

    @BeforeAll
    public static void init(){
        List<Car> availableCars = List.of(bmw,audi,vauxhall,fiat);

        when(carInventory.getAllCars()).thenReturn(availableCars);
        fluxHandler.carInventory = carInventory;
    };

    @Test
    public void getAllCarsTst() {
        var carsFlux = fluxHandler.getAllCars();
        StepVerifier.create(carsFlux).
                expectNext(bmw,audi,vauxhall,fiat)
                .verifyComplete();

    }
}