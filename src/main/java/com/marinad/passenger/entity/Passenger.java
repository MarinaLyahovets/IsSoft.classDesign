package com.marinad.passenger.entity;
import com.google.common.base.Preconditions;
import com.marinad.ticket.entity.Ticket;
import com.marinad.user.entity.User;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Passenger {
    private final User passenger;
    private final Ticket ticket;

    private Passenger(User passenger, Ticket ticket) {
        log.info("Passenger is created");
        this.passenger = passenger;
        this.ticket = ticket;
        log.info("Passenger created");
    }

    public static Passenger of(User passenger, Ticket ticket){
        Preconditions.checkNotNull(passenger, "Passenger is null");
        Preconditions.checkNotNull(ticket, "Ticket is null");
        return new Passenger(passenger, ticket);
    }


}
