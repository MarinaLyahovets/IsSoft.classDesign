package com.marinad.ticket.entity;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.sql.Time;
import java.util.Objects;
import java.util.UUID;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

@Slf4j
@Getter
public class Ticket {
    private int price;
    private final String id;
    private final String placeOfDeparture;
    private final String placeOfArrival;
    private final Time timeOfDeparture;
    private final Time timeOfArrival;

    private Ticket(String id, String placeOfDeparture, String placeOfArrival, Time timeOfDeparture, Time timeOfArrival) {
        log.info("Ticket is created");
        this.id = id;
        this.placeOfDeparture = placeOfDeparture;
        this.placeOfArrival = placeOfArrival;
        this.timeOfDeparture = timeOfDeparture;
        this.timeOfArrival = timeOfArrival;
        log.info("Ticket created");
    }

    public static Ticket of(String placeOfDeparture, String placeOfArrival, Time timeOfDeparture, Time timeOfArrival){
        checkNotNull(placeOfDeparture, "Place of departure is null");
        checkNotNull(placeOfArrival, "Place of arrival is null");
        checkArgument(!placeOfArrival.equalsIgnoreCase(placeOfDeparture), "Place of departure and arrival are the same!");
        checkArgument(!timeOfDeparture.equals(timeOfArrival), "Time of departure and arrival are the same!");

        return new Ticket(UUID.randomUUID().toString(), placeOfDeparture, placeOfArrival, timeOfDeparture, timeOfArrival);
    }

    public void setPrice(int price){
        log.info("Price is set");
        checkArgument(price > 0, "Invalid price value");
        this.price = price;
        log.info("Correct price is set");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(id, ticket.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
