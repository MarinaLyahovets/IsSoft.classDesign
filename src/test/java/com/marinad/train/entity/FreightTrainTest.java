package com.marinad.train.entity;

import com.marinad.cargo.entity.Cargo;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FreightTrainTest {

    @Test
    void of_invalid() {
            assertThrows(IllegalArgumentException.class, ()->{
            FreightTrain freightTrain = FreightTrain.of("61-4445", -34);
        });
    }

    @Test
    void of_successfully() {
        FreightTrain freightTrain = FreightTrain.of("61-4445", 184);
        assertThat(freightTrain.getLiftingCapacity(), is(184));
    }

    @Test
    void addCaro_nullInvalid() {
        FreightTrain freightTrain = FreightTrain.of("61-4445", 158);
        assertThrows(NullPointerException.class, ()->{
            freightTrain.addCaro(null);
        });

    }

    @Test
    void addCargo_invalid() {
        FreightTrain freightTrain = FreightTrain.of("61-4445", 158);
        Cargo cargo = Cargo.of("Кирпичи", 127);
        freightTrain.addCaro(cargo);
        assertThrows(IllegalStateException.class, ()->{
            freightTrain.addCaro(cargo);
        });
    }

    @Test
    void getCargoList_invalid() {
        FreightTrain freightTrain = FreightTrain.of("61-4445", 158);
        Cargo cargo = Cargo.of("Кирпичи", 127);
        freightTrain.addCaro(cargo);
        List<Cargo> list = new ArrayList<Cargo>();
        list.add(cargo);
        list.add(cargo);
        assertNotEquals(freightTrain.getCargoList(), list);
    }

    @Test
    void getCargoList_successfully() {
        FreightTrain freightTrain = FreightTrain.of("61-4445", 158);
        Cargo cargo = Cargo.of("Кирпичи", 127);
        freightTrain.addCaro(cargo);
        List<Cargo> list = new ArrayList<Cargo>();
        list.add(cargo);
        assertThat(freightTrain.getCargoList(), is(list));
    }


}