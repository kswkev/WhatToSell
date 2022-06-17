package com.kev;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ItemFactory {

    public static final String DIV_CLASS_ITEM_INFO = "<div class=\"item_info\">";
    public static final String DIV_END = "</div>";
    public static final String SPAN = "</span>";
    public static final String H_1 = "</h1>";
    public static final String FISHING_VENTURES_XML = "resources/FishingVentures.xml";



    public static Item generateItem(int id) {
        Item item = new Item(id);

        item.setName(getItemNameFor(id));
        item.setListingsMap(getListingsMap(id));

        return item;
    }

    public static List<Item> fetchFishingVentures() {
        List<Item> items = XMLDomParser.parseXML(FISHING_VENTURES_XML);

        for (Item item : items) {
            item.setListingsMap(getListingsMap(item.getId()));
        }

        return items;
    }

    private static Map<String, ArrayList<Listing>> getListingsMap(int id) {
        return ListingFactory.getListingsMap(id, "Chaos");
    }


    private static String getItemNameFor(int id) {

        System.out.println("Finding item name for item with id of " + id);
        String itemName;

        String itemDetailsHTML = RestService.fetchDataFrom(RestURLConstants.ITEM_DETAILS + id);

//        System.out.println(itemDetailsHTML);

        int divStart = itemDetailsHTML.indexOf(DIV_CLASS_ITEM_INFO);
        int divEnd = itemDetailsHTML.indexOf(DIV_END, divStart);
        String currentText = itemDetailsHTML.substring(divStart, divEnd);
        int spanEnd = currentText.indexOf(SPAN) + SPAN.length();
        int h1End = currentText.indexOf(H_1);
        currentText = currentText.substring(spanEnd, h1End);

        itemName = currentText.trim();

        System.out.println("Item name " + itemName + " found for item with id of " + id);

        return itemName;
    }
}
