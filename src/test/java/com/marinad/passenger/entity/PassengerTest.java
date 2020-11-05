package com.marinad.passenger.entity;
import com.marinad.ticket.entity.Ticket;
import com.marinad.user.entity.User;
import org.junit.jupiter.api.Test;

import java.sql.Time;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class PassengerTest {

    @Test
    void of_nullInvalid() {
        assertThrows(NullPointerException.class, ()->{
            Passenger passenger = Passenger.of(null, Ticket.of("Minsk", "Moscow",
                    new Time(43200000), new Time(46800000)));
        });
        assertThrows(NullPointerException.class, ()->{
            Passenger passenger = Passenger.of(User.of("Lyahovets", "Marina"), null);
        });
    }
    @Test
    void of_successfully(){
        User user = User.of("Lyahovets", "Marina");
        Ticket ticket = Ticket.of("Minsk", "Moscow", new Time(43200000), new Time(46800000));
        Passenger passenger = Passenger.of(user, ticket);
        assertThat(passenger.getPassenger(), is(user));
        assertThat(passenger.getTicket(), is(ticket));
    }
}