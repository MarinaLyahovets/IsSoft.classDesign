package com.marinad.driver.entity;

import com.marinad.user.entity.User;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

import static com.google.common.base.Preconditions.*;

@Slf4j
@Getter
public class Driver {
    public static final int DRIVING_AGE = 18;
    private boolean havingDrivingLicense;
    private final User driver;

    private Driver(boolean havingDrivingLicense, User driver) {
        log.info("Driver is created");
        this.havingDrivingLicense = havingDrivingLicense;
        this.driver = driver;
        log.info("Driver created");

    }
    public static Driver of(boolean havingDrivingLicense, User driver){
        checkNotNull(driver, "User is null");
        checkArgument(driver.getAge() >= DRIVING_AGE, "User is too young!");
        return new Driver(havingDrivingLicense, driver);
    }

     @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver1 = (Driver) o;
        return Objects.equals(driver, driver1.driver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(driver);
    }
}
