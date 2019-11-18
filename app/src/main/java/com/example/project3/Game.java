package com.example.project3;

import java.util.ArrayList;
import java.util.List;

public class Game {
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

    public Game(int picid, String name, String price, String detail){
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



}
