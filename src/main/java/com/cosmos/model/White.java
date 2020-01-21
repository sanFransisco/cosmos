package com.cosmos.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class White extends Nothing {

    @JsonProperty("creator")
    private String creator;

    public White(Map<String,String> fields){
      super();
      this.copy(fields);
    }

    @Override
    public void copy(Map<String,String> nothing) {
        super.copy(nothing);
        if(nothing.containsKey("creator"))
            this.creator= nothing.get("creator");

    }
}
