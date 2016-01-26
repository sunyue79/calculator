/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 */
package com.sunyue.util.calculator.impl.operator.math;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.logging.Logger;

import com.sunyue.util.calculator.api.CalculationException;
import com.sunyue.util.calculator.api.Operator;

import java.util.logging.Level;

/**
 * This class is used to provide utilities for mathematics calculation. Only
 * support <code>java.lang.Number</code> or String which can be convert to
 * <code>java.lang.Number</code>.
 * 
 * @author sunyue05
 */
public abstract class MathOperatorSupport extends Operator {

    private static final Logger LOG = Logger.getLogger(MathOperatorSupport.class
            .getName());

    public MathOperatorSupport(String symbol, int priority) {
        super(symbol, priority);
    }

    public MathOperatorSupport(String symbol) {
        super(symbol);
    }

    /**
     * Convert Number or String object to <code>java.lang.Number</code> object
     * 
     * @param obj
     * @return
     */
    public BigDecimal getNumber(Object obj) {
        if (obj instanceof BigDecimal) {
            return (BigDecimal) obj;
        }
        if (obj instanceof Integer) {
            return new BigDecimal((Integer) obj);
        }
        if (obj instanceof Long) {
            return new BigDecimal((Long) obj);
        }
        if (obj instanceof Double) {
            return new BigDecimal(obj.toString());
        }
        if (obj instanceof Float) {
            return new BigDecimal(obj.toString());
        }
        if (obj instanceof String) {
            try {
                return getNumber(NumberFormat.getInstance().parse(
                        obj.toString()));
            } catch (ParseException e) {
                throw new CalculationException(
                        "Calculate number is not supportted: " + obj, e);
            }
        }
        throw new CalculationException("Calculate number is not supportted: "
                + obj);
    }

    @Override
    public boolean support(Object[] args) {
        if (args == null || args.length != super.getDimension()) {
            return false;
        }
        for (Object obj : args) {
            try {
                getNumber(obj);
            } catch (Exception e) {
                LOG.log(Level.SEVERE, obj + " is not supported by operator +"
                        + this.getSymbol(), e);
                return false;
            }
        }
        return true;
    }
}
