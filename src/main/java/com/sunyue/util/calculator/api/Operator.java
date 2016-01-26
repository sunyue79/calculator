/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 */
package com.sunyue.util.calculator.api;

import org.apache.commons.lang.StringUtils;

import com.sunyue.util.calculator.impl.parser.AbstractExpressionParser;

/**
 * Operator object used to define a kind of calculation.
 * 
 * @author sunyue05
 */
public abstract class Operator {

    /**
     * default operator dimension
     */
    private static final int DEFAULT_DIMENSION = 2;

    /**
     * default operator priority
     */
    protected static final int DEFAULT_PRIORITY = 10;

    /**
     * Symbol string
     */
    private String symbol;

    /**
     * How many arguments to be calculated
     */
    private int dimension = DEFAULT_DIMENSION;

    /**
     * Calculation priority compared with other operators
     */
    private int priority = DEFAULT_PRIORITY;

    /**
     * A snapshot of the operator used by toString, equals and hashCode methods
     */
    private String snapshot;

    public Operator(String symbol) {
        this(symbol, DEFAULT_DIMENSION, DEFAULT_PRIORITY);
    }

    public Operator(String symbol, int priority) {
        this(symbol, DEFAULT_DIMENSION, priority);
    }

    protected Operator(String symbol, int dimension, int priority) {
        if (StringUtils.isBlank(symbol)) {
            throw new CalculationException("Operator can not be blank");
        }
        symbol = symbol.trim();
        // remained characters can't be operators
        if (AbstractExpressionParser.REMAINED_SYMBOL.contains(symbol)) {
            throw new CalculationException(
                    "Operator can not be one of: , ( ) \\ .");
        }
        // at least one number involved calculation
        if (dimension <= 0) {
            throw new CalculationException(
                    "Operator dimension at least one, actual = " + dimension);
        }
        this.symbol = symbol;
        this.dimension = dimension;
        this.priority = priority;
        this.snapshot = new StringBuilder(symbol).append("(").append(priority)
                .append(",").append(dimension).append(")").toString();
    }

    public String getSymbol() {
        return symbol;
    }

    public int getDimension() {
        return dimension;
    }

    public int getPriority() {
        return priority;
    }

    public String toString() {
        return snapshot;
    }

    /**
     * Perform concrete calculation.
     * 
     * @param args
     * @return
     */
    public abstract Object calculate(Object[] args);

    /**
     * Whether the input arguments are supported by this operator.
     * 
     * @param args
     * @return
     */
    public boolean support(Object[] args) {
        return true;
    }

    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Operator
                && this.getClass().equals(obj.getClass())) {
            return obj == this || toString().equals(obj.toString());
        }
        return false;
    }

    public int hashCode() {
        return toString().hashCode();
    }
}
