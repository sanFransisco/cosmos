package com.cosmos.model;

import java.util.Map;

//Represent Black Nothing
public class Black extends Nothing {

    private String isBlackHole;

    public Black(Map<String, String> fields) {

        super();
        this.copy(fields);
    }

    @Override
    public void copy(Map<String, String> nothing) {

        super.copy(nothing);

//        if (nothing.containsKey("isBlackHole")) {
//            this.isBlackHole = new String(nothing.get("isBlackHole"));
//        }
    }

    @Override
    public Map<String, String> toJson() {

        Map<String, String> json = super.toJson();
        json.put("isBlackHole", this.isBlackHole);

        return json;
    }
}
