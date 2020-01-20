package com.cosmos.model;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Black extends Nothing {
    @JsonProperty("isBlackHole")
    private boolean isBlackHole;

    public Black(HashMap<String, String> nothing) {
        this.isBlackHole = Boolean.parseBoolean(nothing.get("isBlackHole"));
    }

    @Override
    public void copy(HashMap<String, String> nothing) {

        super.copy(nothing);
        if (nothing.containsKey("isBlackHole"))
            this.isBlackHole = Boolean.parseBoolean(nothing.get("isBlackHole"));

    }
}
