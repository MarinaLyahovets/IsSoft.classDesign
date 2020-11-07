package com.marinad.ticket.entity;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import java.sql.Time;
import static org.junit.jupiter.api.Assertions.*;

class TicketTest {

    @Test
    void setPrice_successfully() {
        Ticket ticket = Ticket.of("Minsk", "Moscow", new Time(43200000), new Time(46800000));
        ticket.setPrice(133);

        assertThat(ticket.getPrice(), is(equalTo(133)));
    }

    @Test
    void setPrice_invalid(){
        Ticket ticket = Ticket.of("Minsk", "Moscow", new Time(43200000), new Time(46800000));

        assertThrows(IllegalArgumentException.class, ()->{
            ticket.setPrice(-12);
        });
    }

    @Test
    void of_equalsInvalid(){
        assertThrows(IllegalArgumentException.class, ()->{
            Ticket ticket = Ticket.of("Minsk", "Minsk", new Time(43200000), new Time(44200001));
        });

        assertThrows(IllegalArgumentException.class, ()->{
            Ticket ticket = Ticket.of("Minsk", "Moscow", new Time(43200000), new Time(43200000));
        });
    }
    @Test
    void of_nullInvalid(){
        assertThrows(NullPointerException.class, ()->{
            Ticket ticket = Ticket.of(null, "Minsk", new Time(43200000), new Time(44200001));
        });

        assertThrows(NullPointerException.class, ()->{
            Ticket ticket = Ticket.of("Minsk", null, new Time(43200000), new Time(43200000));
        });
    }

    @Test
    void of_successfully(){
        Ticket ticket = Ticket.of("Minsk", "Moscow", new Time(43200000), new Time(44200001));

        assertThat(ticket.getPlaceOfArrival(), equalTo("Moscow"));
        assertThat(ticket.getPlaceOfDeparture(), equalTo("Minsk"));
        assertThat(ticket.getTimeOfArrival(), equalTo(new Time(44200001)));
        assertThat(ticket.getTimeOfDeparture(), equalTo(new Time(43200000)));
    }


}