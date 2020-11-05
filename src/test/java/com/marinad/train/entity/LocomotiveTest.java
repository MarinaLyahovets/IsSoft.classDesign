package com.marinad.train.entity;

import com.marinad.driver.entity.Driver;
import com.marinad.user.entity.User;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class LocomotiveTest {

    @Test
    void of_invalid() {
        assertThrows(IllegalArgumentException.class, ()->{
            Locomotive locomotive = Locomotive.of("61-4000", "Электровоз", -15);
        });
    }

    @Test
    void of_successfully() {
        Locomotive locomotive = Locomotive.of("61-4000", "Электровоз", 15);
        assertThat(locomotive.getMaxSpeed(), is(15));
    }

    @Test
    void setDriver_invalid() {
        Locomotive locomotive = Locomotive.of("61-4000", "Электровоз", 15);
        User user = User.of("Lyahovets", "Marina");
        user.setAge(19);
        Driver driver = Driver.of(false, user);
        assertThrows(IllegalStateException.class, ()->{
            locomotive.setDriver(driver);
        });
    }

    @Test
    void setDriver_successfuly() {
        Locomotive locomotive = Locomotive.of("61-4000", "Электровоз", 15);
        User user = User.of("Lyahovets", "Marina");
        user.setAge(19);
        Driver driver = Driver.of(true, user);
        locomotive.setDriver(driver);
        assertThat(locomotive.getDriver(), is(driver));
    }


}