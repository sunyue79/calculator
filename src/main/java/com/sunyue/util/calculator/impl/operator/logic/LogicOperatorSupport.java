/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 */
package com.sunyue.util.calculator.impl.operator.logic;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.sunyue.util.calculator.api.CalculationException;
import com.sunyue.util.calculator.api.Operator;

/**
 * This class is used to provide utilities for logical calculation. Only support
 * <code>java.lang.Boolean</code> or String which can be convert to
 * <code>java.lang.Boolean</code>.
 * 
 * @author sunyue05
 */
public abstract class LogicOperatorSupport extends Operator {

    private static final Logger LOG = Logger
            .getLogger(LogicOperatorSupport.class.getName());

    public LogicOperatorSupport(String symbol, int priority) {
        super(symbol, priority);
    }

    public LogicOperatorSupport(String symbol) {
        super(symbol);
    }

    public LogicOperatorSupport(String symbol, int dimension, int priority) {
        super(symbol, dimension, priority);
    }

    /**
     * Convert Number or String object to <code>java.lang.Number</code> object
     * 
     * @param obj
     * @return
     */
    public Boolean getBoolean(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            if ("true".equalsIgnoreCase(obj.toString())) {
                return Boolean.TRUE;
            }
            if ("false".equalsIgnoreCase(obj.toString())) {
                return Boolean.FALSE;
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
                getBoolean(obj);
            } catch (Exception e) {
                LOG.log(Level.SEVERE, obj + " is not supported by operator +"
                        + this.getSymbol(), e);
                return false;
            }
        }
        return true;
    }
}
