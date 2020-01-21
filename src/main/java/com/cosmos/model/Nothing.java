package com.cosmos.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public abstract class Nothing {

    private String name;

    private String description;

    private String id;

    //used to generate unique ids during app life-time
    private static final Random rnd = new Random(10000);

    protected Nothing() {
        this.id = getUniqueId();
    }

    public void copy(Map<String, String> fields) {

        this.name = fields.get("name");
        this.description = fields.get("description");
    }

    public Map<String, String> toJson() {

        Map<String, String> res = new HashMap<>();
        res.put("name", this.name);
        res.put("description", this.description);
        res.put("id", this.id.toString());

        return res;
    }

    public String getId() {
        return this.id;
    }

    private static String getUniqueId() {
        return Integer.toString(Math.abs(rnd.nextInt()));
    }

}
