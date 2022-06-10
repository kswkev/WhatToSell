package com.kev;

import java.util.Date;

public class Listing {

    private Date lastReview;
    private int pricePerUnit;
    private int quantity;
    private String worldName;
    private int worldId;
    private boolean hq;
    private int totalCost;

    public Date getLastReview() {
        return lastReview;
    }

    public void setLastReview(Date lastReview) {
        this.lastReview = lastReview;
    }

    public int getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(int pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getWorldName() {
        return worldName;
    }

    public void setWorldName(String worldName) {
        this.worldName = worldName;
    }

    public int getWorldId() {
        return worldId;
    }

    public void setWorldId(int worldId) {
        this.worldId = worldId;
    }

    public boolean isHq() {
        return hq;
    }

    public void setHq(boolean hq) {
        this.hq = hq;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "Listing{" +
                "lastReview=" + lastReview +
                ", pricePerUnit=" + pricePerUnit +
                ", quantity=" + quantity +
                ", worldName='" + worldName + '\'' +
                ", worldId=" + worldId +
                ", hq=" + hq +
                ", totalCost=" + totalCost +
                '}';
    }
}
