package com.cosmos.controller;

import com.cosmos.model.Black;
import com.cosmos.model.Nothing;
import com.cosmos.model.White;
import com.cosmos.repository.NothingService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.*;

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
    public ResponseEntity<?> getAllNothings(HttpServletResponse response) {

        String res = new String();

        try {
            List<Nothing> nothingList = this.repository.getAllNothings();

            if (nothingList.size() > 0) {
                res = this.gson.toJson(nothingList).intern();
            }else{
               return ResponseEntity.ok("[]");
            }

        } catch (Exception exp) {
        }
        return ResponseEntity.ok(res);
    }

    @DeleteMapping("/delete")
    public void deleNothing() {
        //handle failure
    }
//    @RequestBody HashMap<String,String> body ,HttpServletResponse response

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createNothing(HttpServletRequest requeset, HttpServletResponse response, @RequestBody String data) {
        JsonObject body = parser.parse(data).getAsJsonObject();
        JsonElement nothingType = body.get("type");
        JsonObject nothing = body.get("nothing").getAsJsonObject();
        Nothing nothingObj = null;
        if(nothingType.getAsString().equals("White")){
            Map<String,String> map = new HashMap<String,String>();
            map = (Map<String,String>) gson.fromJson(nothing, map.getClass());
            nothingObj = new White(map);
        }else if(nothingType.getAsString().equals("Black")){
            Map<String,String> map = new HashMap<String,String>();
            map = (Map<String,String>) gson.fromJson(nothing, map.getClass());
            nothingObj = new Black(map);
        }

        this.repository.addNothing(nothingObj);


        return ResponseEntity.ok(this.gson.toJson(nothingObj));

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
    public ResponseEntity<?>  updateNothing(HttpServletRequest request,  @RequestBody String data) {

        JsonObject body = parser.parse(data).getAsJsonObject();
        String id = body.get("id").toString();
        JsonObject nothing = body.get("nothing").getAsJsonObject();
        this.repository.getAllNothings().forEach((item)->{
            //found
            if(item.getId().equals(id)){
                Map<String,String> map = new HashMap<String,String>();
                map = (Map<String,String>) gson.fromJson(nothing, map.getClass());
                item.copy(map);
            }
        });
        //empty list to signal success and save bandwith
        return ResponseEntity.ok("[]");

    }

}
