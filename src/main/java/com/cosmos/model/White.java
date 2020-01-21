package com.cosmos.model;

import java.util.Map;

//Represent White Nothing
public class White extends Nothing {

    private String creator;

    public White(Map<String, String> fields) {
        super();
        this.copy(fields);
    }

    @Override
    public void copy(Map<String, String> nothing) {
        super.copy(nothing);
        if (nothing.containsKey("creator"))
            this.creator = nothing.get("creator");

    }

    @Override
    public Map<String, String> toJson() {

        Map<String, String> json = super.toJson();
        json.put("creator", this.creator);
        return json;
    }
}
