package com.cosmos.model;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class White extends Nothing {

    @JsonProperty("creator")
    private String creator;

    public White(HashMap<String,String> fields){
        this.creator = fields.get("creator");
    }

    @Override
    public void copy(HashMap<String,String> nothing) {
        super.copy(nothing);
        if(nothing.containsKey("creator"))
            this.creator= nothing.get("creator");

    }
}
