package com.marinad.train.entity;

import com.marinad.passenger.entity.Passenger;
import com.marinad.ticket.entity.Ticket;
import com.marinad.user.entity.User;
import org.junit.jupiter.api.Test;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class PassengerTrainTest {

    @Test
    void addPassenger_nullInvalid() {
        PassengerTrain passengerTrain = PassengerTrain.of("61-4445", 158);
        assertThrows(NullPointerException.class, ()->{
            passengerTrain.addPassenger(null);
        });

    }

    @Test
    void addPassenger_invalid() {
        PassengerTrain passengerTrain = PassengerTrain.of("61-4445", 1);
        Passenger passenger = Passenger.of(User.of("Lyahovets", "Marina"),
                Ticket.of("Minsk", "Moscow", new Time(4200000), new Time(4500000)));
        passengerTrain.addPassenger(passenger);
        assertThrows(IllegalStateException.class, ()->{
            passengerTrain.addPassenger(passenger);
        });

    }

    @Test
    void getListPassengers_successfully() {
        PassengerTrain passengerTrain = PassengerTrain.of("61-4445", 1);
        Passenger passenger = Passenger.of(User.of("Lyahovets", "Marina"),
                Ticket.of("Minsk", "Moscow", new Time(4200000), new Time(4500000)));
        passengerTrain.addPassenger(passenger);
        List<Passenger> list = new ArrayList<Passenger>();
        list.add(passenger);
        assertThat(passengerTrain.getListPassengers(), is(list));
    }

    @Test
    void getListPassengers_invalid() {
        PassengerTrain passengerTrain = PassengerTrain.of("61-4445", 1);
        Passenger passenger = Passenger.of(User.of("Lyahovets", "Marina"),
                Ticket.of("Minsk", "Moscow", new Time(4200000), new Time(4500000)));
        passengerTrain.addPassenger(passenger);
        List<Passenger> list = new ArrayList<Passenger>();
        list.add(passenger);
        list.add(passenger);
        assertNotEquals(passengerTrain.getListPassengers(), list);
    }

    @Test
    void of_invalid() {
        assertThrows(IllegalArgumentException.class, ()->{
            PassengerTrain passengerTrain = PassengerTrain.of("61-4445", -1);
        });
        assertThrows(IllegalArgumentException.class, ()->{
            PassengerTrain passengerTrain = PassengerTrain.of("61-4445", 180);
        });
    }

    @Test
    void of_successfully() {
        PassengerTrain passengerTrain = PassengerTrain.of("61-4445", 1);
        assertThat(passengerTrain.getCountSeat(), is(1));
    }

}