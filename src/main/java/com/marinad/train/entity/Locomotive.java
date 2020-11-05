package com.marinad.train.entity;


import com.marinad.driver.entity.Driver;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import static com.google.common.base.Preconditions.*;

@Slf4j
@Getter
public class Locomotive extends Train {
    private final String typeLocomotive;
    private final int maxSpeed;
    private Driver driver;

    private Locomotive(String model, String typeLocomotive, int maxSpeed) {
        super(model, "Локомотив");
        this.typeLocomotive = typeLocomotive;
        this.maxSpeed = maxSpeed;
        log.info("Locomotive created");
    }

    public static Locomotive of(String model, String typeLocomotive, int maxSpeed){
        checkArgument(maxSpeed > 0, "Incorrect maximum speed");
        return new Locomotive(model, typeLocomotive, maxSpeed);
    }

    public void setDriver(Driver driver){
        checkState(driver.isHavingDrivingLicense(), "The driver has no license");
        this.driver = driver;
        log.info("Correct driver is set");
    }



}
