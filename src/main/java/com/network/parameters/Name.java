package main.java.com.network.parameters;

import java.util.Objects;

public class Name {
    private final String name;

    public Name(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
