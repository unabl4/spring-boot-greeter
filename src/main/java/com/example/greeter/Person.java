package com.example.greeter;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"name","timestamp","version"})
public class Person {
    private String name;

    @JsonGetter(value = "nimi")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // augmented params
    public String getTimestamp() {
        return String.valueOf(System.currentTimeMillis() / 1000L);
    }

    @JsonGetter(value = "v")
    public String getVersion() {
        return "1.0";
    }
}
