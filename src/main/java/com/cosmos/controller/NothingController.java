package com.cosmos.controller;

import com.cosmos.model.Black;
import com.cosmos.model.Nothing;
import com.cosmos.model.White;
import com.cosmos.repository.NothingService;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping(value = "/crud")
@CrossOrigin(origins="http://localhost:4200")
@Controller()
public class NothingController {
    private final JsonParser parser;
    private final Gson gson;
    private final NothingService repository;

    public NothingController() {
        this.parser = new JsonParser();
        this.gson = new Gson();
        repository = new NothingService();
    }

    @GetMapping("/hello")
    public void getHello(HttpServletResponse res) {
        try {
            PrintWriter out = res.getWriter();
            out.println("Hello, world!");
            out.close();
        } catch (Exception exp) {
        }
    }

    @GetMapping("/all")
    public void getAllNothings(HttpServletResponse response) {
        try {
            StringBuilder res = new StringBuilder();
            List<Nothing> nothingList = this.repository.getAllNothings();
            PrintWriter out = response.getWriter();

            if (nothingList.size() > 0) {
                this.gson.toJson(nothingList);
            }else{
                out.print("[]");
            }
            out.close();
        } catch (Exception exp) {
        }
    }

    @DeleteMapping("/delete")
    public void deleNothing() {
        //handle failure
    }
//    @RequestBody HashMap<String,String> body ,HttpServletResponse response
    @RequestMapping(value={"/create/{data}"}, method = RequestMethod.POST)
    public void createNothing(HttpServletRequest requeset, HttpServletResponse response, @PathVariable Nothing data) {
        System.out.println(requeset);

//        String nothing = body.get("nothing");
//        String type = body.get("type");
//        HashMap<String, String> nothingJson = this.gson.fromJson(nothing, HashMap.class);
//        Nothing obj = null;
//
//        if(type == "White"){
//            obj = new White(nothingJson);
//        }else if(type=="Black"){
//            obj = new Black(nothingJson);
//        }
//
//        repository.addNothing(obj);
        //handle failure
    }

    @PostMapping("/update")
    public void updateNothing(HttpServletRequest request) {
        //handle failure

    }

}
