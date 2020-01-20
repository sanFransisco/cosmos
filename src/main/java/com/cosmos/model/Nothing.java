package com.cosmos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Random;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class Nothing {

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    //used to generate unique ids during app life-time
    private static final Random rnd = new Random(10000);

    @JsonProperty("id")
    protected static int id;

    protected Nothing() {
        id = getUniqueId();
    }

    public void copy(HashMap<String,String> fields) {

        this.name = fields.get("name");
        this.description = fields.get("description");
    }

    private static int getUniqueId() {
        return rnd.nextInt();
    }

}
