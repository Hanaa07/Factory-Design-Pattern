package com.emsi;

/**
 * Factory is an object for creating other objects. It provides a static method to
 * create and return objects of varying classes, in order to hide the implementation logic
 * and makes client code focus on usage rather than objects initialization and management.
 *
 * <p>In this example an alchemist manufactures coins. CoinFactory is the factory class, and it
 * provides a static method to create different types of coins.
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("The alchemist begins his work.");
        var coin1 = CoinFactory.getCoin(CoinType.COPPER);
        var coin2 = CoinFactory.getCoin(CoinType.GOLD);
        System.out.println(coin1.getDescription());
        System.out.println(coin2.getDescription());
    }
}