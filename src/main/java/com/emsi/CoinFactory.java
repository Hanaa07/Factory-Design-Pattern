package com.emsi;

/**
 * Factory of coins.
 */
public class CoinFactory {

    /**
     * Factory method takes as a parameter the coin type and calls the appropriate class.
     */
    public static Coin getCoin(CoinType type) {
        return type.getConstructor().get();
    }
}