package com.marinad.cargo.entity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

class CargoTest {

    @Test
    void of_invalid(){
        assertThrows(IllegalArgumentException.class, ()->{
            Cargo cargo = Cargo.of("Кирпичи", -13);
        });
    }

    @Test
    void of_successfully(){
        Cargo cargo = Cargo.of("Кирпичи", 13);

        assertThat(cargo.getWeight(), is(13));
    }
}