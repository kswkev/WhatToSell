package com.kev;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Item {

    private int id;
    private String name;
    private int quantity;
    private int vendorBuysFor;
    private int level;
    private Map<String, ArrayList<Listing>> listingsMap;
    private Map<String, Listing> cheapistListingsMap;
    private Map<String, Listing> cheapistHQListingsMap;

    public Item(int id) {
        this.id = id;
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Item(int id, String name, int quantity, int vendorBuysFor, int level) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.vendorBuysFor = vendorBuysFor;
        this.level = level;
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
        populateCheapistListingsMap();
        populateCheapistHQListingsMap();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getVendorBuysFor() {
        return vendorBuysFor;
    }

    public void setVendorBuysFor(int vendorBuysFor) {
        this.vendorBuysFor = vendorBuysFor;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Map<String, Listing> getCheapistListingsMap() {
        return cheapistListingsMap;
    }

    public Map<String, Listing> getCheapistHQListingsMap() {
        return cheapistHQListingsMap;
    }

    private void populateCheapistListingsMap() {
        Map<String, Listing> cheapistListingsMap = new HashMap<String, Listing>();
        for (Map.Entry<String, ArrayList<Listing>> entry : this.listingsMap.entrySet()) {
            if (null != entry.getKey() && null != entry.getValue()) {
                for (Listing listing : entry.getValue()) {
                    if (!listing.isHq()) {
                        cheapistListingsMap.put(entry.getKey(), listing);
                    }
                }
            }
        }
        this.cheapistListingsMap = cheapistListingsMap;
    }

    private void populateCheapistHQListingsMap() {
        Map<String, Listing> cheapistListingsMap = new HashMap<String, Listing>();
        for (Map.Entry<String, ArrayList<Listing>> entry : this.listingsMap.entrySet()) {
            if (null != entry.getKey() && null != entry.getValue()) {
                for (Listing listing : entry.getValue()) {
                    if (listing.isHq()) {
                        cheapistListingsMap.put(entry.getKey(), listing);
                    }
                }
            }
        }
        this.cheapistHQListingsMap = cheapistListingsMap;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", vendorBuysFor=" + vendorBuysFor +
                ", level=" + level +
                ", listingsMap=" + listingsMap +
                '}';
    }
}
