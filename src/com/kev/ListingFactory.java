package com.kev;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ListingFactory {

    public static final String LISTINGS = "\"listings\":[";
    public static final String RECENT_HISTORY = ",\"recentHistory\"";
    public static final String REGEX = "(\\{)(.*?)(\\})";
    public static final String LAST_REVIEW_TIME = "lastReviewTime";
    public static final String PRICE_PER_UNIT = "pricePerUnit";
    public static final String QUANTITY = "quantity";
    public static final String WORLD_NAME = "worldName";
    public static final String WORLD_ID = "worldID";
    public static final String TOTAL = "total";
    public static final String HQ = "hq";

    public static Map<String, ArrayList<Listing>> getListingsMap(int itemId, String world) {

        Map<String, ArrayList<Listing>> listingsMap = new HashMap<String, ArrayList<Listing>>();

        List<Listing> listings = getListings(itemId, world);

        for (Listing listing : listings) {
            String worldName = listing.getWorldName();
            if (!listingsMap.containsKey(worldName)) {
                listingsMap.put(worldName, new ArrayList<Listing>());
            }

            listingsMap.get(worldName).add(listing);
        }

        return listingsMap;
    }

    public static List<Listing> getListings(int itemId, String world) {
        List<Listing> listings = new ArrayList<Listing>();

        String string = RestService.fetchDataFrom(RestURLConstants.MARKET_BOARD_CURRENT_DATA + world + "/" + itemId);
        string = string.substring(string.indexOf(LISTINGS), string.indexOf(RECENT_HISTORY));
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            listings.add(createListingFromData(matcher.group(2)));
        }

        return listings;
    }

    private static Listing createListingFromData(String data) {
        Listing listing = new Listing();

        Map<String, String> values = extractValues(data);

        Date date = new Date(Long.parseLong(values.get(LAST_REVIEW_TIME)) * 1000);
        listing.setLastReview(date);
        listing.setPricePerUnit(Integer.parseInt(values.get(PRICE_PER_UNIT)));
        listing.setQuantity(Integer.parseInt(values.get(QUANTITY)));
        listing.setWorldName(values.get(WORLD_NAME));
        listing.setWorldId(Integer.parseInt(values.get(WORLD_ID)));

        try {
            listing.setTotalCost(Integer.parseInt(values.get(TOTAL)));
        } catch (Exception ex) {
            System.out.println("Failed to parse " + values.get(TOTAL));
        }

        if (values.get(HQ) == "true") {
            listing.setHq(true);
        } else {
            listing.setHq(false);
        }

        return listing;
    }

    private static Map<String, String> extractValues(String data) {
        Map<String, String> map = new HashMap<String, String>();

        for (String item : data.split(",")) {
            String key = item.substring(0, item.indexOf(":"));
            key = key.replace("\"", "");
            String value = item.substring(item.indexOf(":") + 1);
            value = value.replace("\"", "");
            map.put(key, value);
        }

        return map;
    }

}
