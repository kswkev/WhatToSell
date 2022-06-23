package com.kev;

import java.util.ArrayList;
import java.util.List;

public class Advisor {

    private static int AMOUNT_TO_REPORT = 3;

    private List<Item> fishingVentures;

    public void adviseOnFishingVentures(String world) {
        loadFishingVentures();
        List<Item> topSellingFishingVentures = findTopSellingVentures(fishingVentures, world, AMOUNT_TO_REPORT);
        Reporter.printAdvise(topSellingFishingVentures, "fishing ventures", world, false);
    }

    private void loadFishingVentures() {
        this.fishingVentures = ItemFactory.fetchFishingVentures();
    }

    private List<Item> findTopSellingVentures(List<Item> itemList, String world, int amountToReturn) {
        List<Item> topSellers = new ArrayList<>();

        for (int i=0; i<amountToReturn; i++) {
            int topFoundValue = Integer.MIN_VALUE;
            Item currentTop = null;
            for (Item item : itemList) {
                if (!topSellers.contains(item) && item.calculateSellsForWithQuantity(false, world) > topFoundValue) {
                    topFoundValue = item.calculateSellsForWithQuantity(false, world);
                    currentTop = item;
                }
            }
            topSellers.add(currentTop);
        }

        return topSellers;
    }
}
