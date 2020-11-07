package com.marinad.train.entity;


import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class TrainTest {

    @Test
    void setNextTrain_nullInvalid() {
        assertThrows(NullPointerException.class, ()->{
            Train train = Train.of("61-4440", "Unsigned");
            train.setNextTrain(null);
        });
    }

    @Test
    void setNextTrain_equalsInvalid(){
        Train train = Train.of("61-4440", "Unsigned");

        assertThrows(IllegalArgumentException.class, ()->{
            train.setNextTrain(train);
        });
    }

    @Test
    void setNextTrain_successfully(){
        Train train = Train.of("61-4440", "Unsigned");
        Train nextTrain = Train.of("61-4441", "Unsigned");

        train.setNextTrain(nextTrain);

        assertThat(train.getNextTrain(), is(equalTo(nextTrain)));
    }
}