package com.kev;

import java.util.ArrayList;
import java.util.Map;

public class Item {

    private int id;
    private String name;
    private Map<String, ArrayList<Listing>> listingsMap;

    public Item(int id) {
        this.id = id;
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, ArrayList<Listing>> getListingsMap() {
        return listingsMap;
    }

    public void setListingsMap(Map<String, ArrayList<Listing>> listingsMap) {
        this.listingsMap = listingsMap;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", listingsMap=" + listingsMap +
                '}';
    }
}
