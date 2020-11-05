package com.marinad.user.entity;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void setAge_invalid() {
        User user = User.of("Lyahovets", "Marina");
        assertThrows(IllegalArgumentException.class, () ->{ user.setAge(-19);});
    }

    @Test
    void setAge_successfully(){
        User user = User.of("Lyahovets", "Marina");
        user.setAge(19);
        assertThat(user.getAge(), is(equalTo(19)));
    }
}