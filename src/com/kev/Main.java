package com.kev;

public class Main {

    public static void main(String[] args) {

//        System.out.println(RestService.fetchDataFrom(RestURLConstants.MARKET_BOARD_CURRENT_DATA + "chaos/" + "36221"));
//        System.out.println(RestService.fetchDataFrom(RestURLConstants.ITEM_DETAILS + "36221"));

        Item item = ItemFactory.generateItem(9374);
        System.out.println(item.toString());

//        System.out.println(item.toString());

//        ListingFactory.getListings(36221, "Chaos");

//        ListingFactory.extractValues("\"lastReviewTime\":1654780753,\"pricePerUnit\":314,\"quantity\":1,\"stainID\":0,\"worldName\":\"Spriggan\",\"worldID\":85,\"creatorName\":\"\",\"creatorID\":null,\"hq\":false,\"isCrafted\":false,\"listingID\":null,\"materia\":[],\"onMannequin\":false,\"retainerCity\":1,\"retainerID\":\"71e53d0dea8ab39887231831f1cbd7e8a40cf79ccd7f6eb5e168cff3bfc17c82\",\"retainerName\":\"Framar\",\"sellerID\":\"8cdd633c9bc7f04404aa4e83a8ac88246be0c0c857af80ad891c46f0cfdb5e0d\",\"total\":314");
    }


}
