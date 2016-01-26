/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 */
package com.sunyue.util.calculator.api;

/**
 * Bracket "(" or ")" object. Change priority of calculation.
 * 
 * @author sunyue05
 */
public final class Bracket {

    private String symbol;

    public static final Bracket LEFT_BRACKET = new Bracket("(");

    public static final Bracket RIGHT_BRACKET = new Bracket(")");

    private Bracket(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Bracket) {
            Bracket barket = (Bracket) obj;
            return getSymbol().equals(barket.getSymbol());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return getSymbol().hashCode();
    }

    @Override
    public String toString() {
        return getSymbol();
    }

}
