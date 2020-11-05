package com.marinad.cargo.entity;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.UUID;

import static com.google.common.base.Preconditions.*;
@Slf4j
@Getter
public class Cargo {
    private final String id;
    private final String name;
    private final int weight;

    private Cargo(String name, int weight) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.weight = weight;
        log.info("Cargo created");
    }

    public static Cargo of(String name, int weight){
        checkArgument(weight > 0, "Incorrect weight");
        return new Cargo(name, weight);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cargo cargo = (Cargo) o;
        return Objects.equals(id, cargo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}