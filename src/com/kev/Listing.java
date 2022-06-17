package com.kev;

import java.util.Comparator;
import java.util.Date;

public class Listing implements Comparable<Listing> {

    private Date lastReview;
    private Integer pricePerUnit;
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

    public Integer getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(Integer pricePerUnit) {
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

    Comparator<Listing> compareByPricePerUnit = new Comparator<Listing>() {
        @Override
        public int compare(Listing o1, Listing o2) {
            return o1.getPricePerUnit().compareTo(o2.getPricePerUnit());
        }
    };

    @Override
    public int compareTo(Listing o) {
        return o.getPricePerUnit().compareTo(this.getPricePerUnit());
    }
}
