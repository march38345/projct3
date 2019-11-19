package com.example.project3.db;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private int id;
    private String name;
    private String price;
    private int picid;
    private String detail;
    List<Game> GameList = new ArrayList<>();

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Game(int id,int picid, String name, String price, String detail){

        this.id = id;
        this.picid = picid;
        this.name = name;
        this.price = price;
        this.detail = detail;


}

    public void setGameList(List<Game> gameList) {
        GameList = gameList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setPicid(int picid) {
        this.picid = picid;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public int getPicid() {
        return picid;
    }

    public List<Game> getGameList() {
        return GameList;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
