package com.cosmos.repository;

import com.cosmos.model.Black;
import com.cosmos.model.Nothing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NothingService {
    //In-memory Nothings
    private ArrayList<Nothing> pool;

    public NothingService() {
        //Initialize with size 100
        this.pool = new ArrayList<Nothing>(100);
    }

    public boolean addNothing(Nothing nothing) {
        boolean res = false;
        if(nothing != null) {
            this.pool.add(nothing);
            res = true;
        }
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
        return this.pool.stream().collect(Collectors.toList());
    }


}
