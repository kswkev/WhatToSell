package com.kev;

import java.util.ArrayList;
import java.util.Map;

public class Reporter {

    public static void printItemDetails(Item item) {
        System.out.println("Id: " + item.getId());
        System.out.println("Name: " + item.getName());
        System.out.println("Level: " + item.getLevel());
        System.out.println("Quantity produced: " + item.getQuantity());
        System.out.println("Vendor buy price: " + item.getVendorBuysFor());
        printAllListings(item);
    }

    public static void printItemDetailsForWorld(Item item, String world) {
        System.out.println("Id: " + item.getId());
        System.out.println("Name: " + item.getName());
        System.out.println("Level: " + item.getLevel());
        System.out.println("Quantity produced: " + item.getQuantity());
        System.out.println("Vendor buy price: " + item.getVendorBuysFor());
        printListingsForWorld(item, item.getListingsMap().get(world), world);
    }

    public static void printAllListings(Item item) {

        for (Map.Entry<String, ArrayList<Listing>> entry : item.getListingsMap().entrySet()) {
            printListingsForWorld(item, entry.getValue(), entry.getKey());
        }
    }

    private static void printListingsForWorld(Item item, ArrayList<Listing> listings, String world) {
        System.out.println("Listings for world: " + world);
        System.out.print("\tIs hq");
        System.out.print("\tQuantity");
        System.out.print("\tpricePerUnit");
        System.out.print("\ttotalCost");
        System.out.println("\tlastReview");
        for (Listing listing : listings) {
            printListing(listing);
        }

        System.out.println("");
        System.out.println("Cheapest by price per unit:");
        printListing(item.getCheapistListingsMap().get(world));

        System.out.println("");
        System.out.println("Cheapest HQ by price per unit:");
        printListing(item.getCheapistHQListingsMap().get(world));

        System.out.println("");
    }

    public static void printListing(Listing listing) {
        System.out.print("\t" + listing.isHq());
        System.out.print("\t" + listing.getQuantity());
        System.out.print("\t" + listing.getPricePerUnit());
        System.out.print("\t" + listing.getTotalCost());
        System.out.println("\t" + listing.getLastReview());
    }
}
