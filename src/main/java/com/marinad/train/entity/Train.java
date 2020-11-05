package com.marinad.train.entity;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.UUID;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

@Slf4j
@Getter
public class Train {
    private final String number;
    private final String model;
    private final String type;
    private Train nextTrain;

    protected Train(String model, String type) {
        log.info("Train is created");
        this.number = UUID.randomUUID().toString();
        this.model = model;
        this.type = type;
        log.info("Train created");
    }


    public static Train of(String model, String type){
        return new Train(model, type);
    }

    public void setNextTrain(Train nextTrain){
        checkNotNull(nextTrain, "Next train is null");
        checkArgument(!this.equals(nextTrain), "This train and next train are same!");
        this.nextTrain = nextTrain;
        log.info("Correct next train is set");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Train train = (Train) o;
        return Objects.equals(number, train.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
