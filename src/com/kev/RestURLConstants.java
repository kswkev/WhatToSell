package com.kev;

public class RestURLConstants {

    //    add world name to the end e.g. Moogle
    public static final String LEAST_RECENTLY_UPDATED_ITEMS_BY_WORLD = "https://universalis.app/api/extra/stats/least-recently-updated?world=";

    //    add DC NAME to the end e.g. Chaos
    public static final String LEAST_RECENTLY_UPDATED_ITEMS_BY_DC = "https://universalis.app/api/extra/stats/least-recently-updated?dcName=";

    //    add world (or data center), followed by / then a comman seperated list of ids
    public static final String MARKET_BOARD_CURRENT_DATA = "https://universalis.app/api/";

    //    add world (or data center), followed by / then a comman seperated list of ids
    public static final String MARKET_BOARD_SALE_HISTORY = "https://universalis.app/api/history/";

    //   returns all item ids
    public static final String MARKETABLE_ITEMS = "https://universalis.app/api/marketable";

    //    add data center
    public static final String RECENTLY_UPDATED_BY_DC = "https://universalis.app/api/extra/stats/most-recently-updated?dcName=";

    //    add world
    public static final String RECENTLY_UPDATED_BY_WORLD = "https://universalis.app/api/extra/stats/most-recently-updated?world=";

    //    item page, add item id
    public static final String ITEM_DETAILS = "https://universalis.app/market/";
}
