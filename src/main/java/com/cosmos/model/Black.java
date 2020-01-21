package com.cosmos.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Black extends Nothing {
    @JsonProperty("isBlackHole")
    private Boolean isBlackHole;

    public Black(Map<String, String> fields) {
      super();
      this.copy(fields);
    }

    @Override
    public void copy(Map<String, String> nothing) {

        super.copy(nothing);
        if (nothing.containsKey("isBlackHole"))
            this.isBlackHole = Boolean.parseBoolean(nothing.get("isBlackHole"));

    }
}
