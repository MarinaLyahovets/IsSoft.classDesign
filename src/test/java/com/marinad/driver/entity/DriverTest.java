package com.marinad.driver.entity;
import com.marinad.user.entity.User;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;


class DriverTest {
    @Test
    void setDriver_successfully(){
        User user = User.of("Lyahovets", "Marina");
        user.setAge(19);
        Driver driver = Driver.of(true, user);

        assertThat(driver.getDriver(), is(equalTo(user)));
        assertThat(driver.isHavingDrivingLicense(), is(equalTo(true)));
    }
    @Test
    void setDriver_invalid(){
        User user = User.of("Lyahovets", "Marina");
        user.setAge(15);

        assertThrows(IllegalArgumentException.class, ()->{
            Driver driver = Driver.of(true, user);
        });
        assertThrows(NullPointerException.class, ()->{
            Driver driver = Driver.of(true, null);
        });
    }


}