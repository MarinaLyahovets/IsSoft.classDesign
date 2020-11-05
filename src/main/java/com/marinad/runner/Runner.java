package com.marinad.runner;
import com.marinad.cargo.entity.Cargo;
import com.marinad.driver.entity.Driver;
import com.marinad.passenger.entity.Passenger;
import com.marinad.ticket.entity.Ticket;
import com.marinad.train.entity.FreightTrain;
import com.marinad.train.entity.Locomotive;
import com.marinad.train.entity.PassengerTrain;
import com.marinad.user.entity.User;


import java.sql.Time;

public class Runner {
    public static void main(String[] args) {
        User user = User.of("Lyahovets","Marina");
        user.setAge(19);
        Ticket ticket = Ticket.of("Minsk", "Moscow", new Time(43200000 ), new Time(82800000));
        Passenger passenger = Passenger.of(user, ticket);
        com.marinad.driver.entity.Driver driver = Driver.of(true, user);
        PassengerTrain passengerTrain = PassengerTrain.of("61-4445", 12);
        passengerTrain.addPassenger(passenger);
        Locomotive locomotive = Locomotive.of("61-4000", "Электровоз", 340);
        locomotive.setDriver(driver);
        Cargo cargo = Cargo.of("кирпичи", 50);
        FreightTrain freightTrain = FreightTrain.of("61-4423", 123);
        freightTrain.addCaro(cargo);


    }
}
