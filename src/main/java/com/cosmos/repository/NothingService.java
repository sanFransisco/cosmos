package com.cosmos.repository;

import com.cosmos.model.Black;
import com.cosmos.model.Nothing;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class NothingService {
    private HashMap<Integer, Nothing> pool;

    public NothingService() {
        this.pool = new HashMap<>();
    }

    public boolean addNothing(Nothing nothing) {
        boolean res = false;

        return res;
    }

    public boolean updateNothing(Integer id) {
        boolean res = false;
        Nothing nothing = getNothingById(id);

        return res;
    }

    public Nothing getNothingById(Integer id) {
        //can return null
        return this.pool.get(id);
    }

    public List<Nothing> getAllNothings() {
        return this.pool.values().stream().collect(Collectors.toList());
    }


}
