package com.marinad.train.entity;

import com.google.common.base.Preconditions;
import com.marinad.passenger.entity.Passenger;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.*;

@Slf4j
public class PassengerTrain extends Train {
    @Getter
    private final int countSeat;
    private final List<Passenger> listPassengers = new ArrayList<>();

    private PassengerTrain(String model, int countSeat) {
        super(model, "Passenger");
        this.countSeat = countSeat;
        log.info("Passenger train created");

    }

    public static PassengerTrain of(String model, int countSeat){
        Preconditions.checkArgument(countSeat > 0);
        Preconditions.checkArgument(countSeat < 170);
        return new PassengerTrain(model, countSeat);
    }

    public void addPassenger(Passenger passenger){
        checkNotNull(passenger, "Passenger is null");
        checkState(listPassengers.size() < countSeat, "Passenger train is full");
        listPassengers.add(passenger);
        log.info("Passenger added to train");
    }
     public List<Passenger> getListPassengers(){
        return List.copyOf(listPassengers);
     }
}