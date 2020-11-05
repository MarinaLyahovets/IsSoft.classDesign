package com.marinad.user.entity;
import com.google.common.base.Preconditions;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.UUID;

@Slf4j
@Getter
public class User {
    private final String id;
    private final String surname;
    private final String name;
    private int age;

    private User(String surname, String name) {
        log.info("User is created");
        this.id = UUID.randomUUID().toString();
        this.surname = surname;
        this.name = name;
        log.info("User created");
    }

    public static User of(String surname, String name){
        return new User(surname, name);
    }

    public void setAge(int age){
        log.info("Age is set");
        Preconditions.checkArgument(age > 0, "Invalid age value!");
        this.age = age;
        log.info("Correct age is set");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
