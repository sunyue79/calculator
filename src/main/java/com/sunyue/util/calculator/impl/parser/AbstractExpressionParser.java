/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 */
package com.sunyue.util.calculator.impl.parser;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.ArrayUtils;

import com.sunyue.util.calculator.api.Bracket;
import com.sunyue.util.calculator.api.CalculationException;
import com.sunyue.util.calculator.api.ExpressionParser;
import com.sunyue.util.calculator.api.Operator;

/**
 * This class is abstract expression parser.
 * 
 * @author sunyue05
 */
public abstract class AbstractExpressionParser implements ExpressionParser {

    /**
     * Separated character
     */
    public static final String SPACE = " ";

    /**
     * Separated character
     */
    public static final String COMMA = ",";

    public static final Set<String> REMAINED_SYMBOL;

    static {
        HashSet<String> remained = new HashSet<String>();
        remained.addAll(Arrays.asList(COMMA, Bracket.LEFT_BRACKET.getSymbol(),
                Bracket.RIGHT_BRACKET.getSymbol(), "\\"));
        REMAINED_SYMBOL = Collections.unmodifiableSet(remained);
    }

    /**
     * Key is symbol(<code>String</code>), value is operator(
     * <code>Operator</code>)
     */
    protected Map<String, Operator> operatorMap = new HashMap<String, Operator>();

    protected AbstractExpressionParser(Operator[] operators) {
        if (ArrayUtils.isEmpty(operators)) {
            throw new CalculationException(
                    "At least one operator is necessary.");
        }
        for (int i = 0; i < operators.length; i++) {
            if (operators[i] != null) {
                operatorMap.put(operators[i].getSymbol(), operators[i]);
            }
        }
    }

    /**
     * Add elements into expression
     * 
     * @param elements
     *            atomic elements of expression
     */
    protected void addToken(List<Object> result, Object... elements) {
        if (!ArrayUtils.isEmpty(elements)) {
            for (Object element : elements) {
                if (element != null && !"".equals(element.toString())) {
                    result.add(element);
                }
            }
        }
    }

    /**
     * The token is an operator or not
     * 
     * @param token
     * @return
     */
    protected boolean isOperator(String token) {
        return operatorMap.containsKey(token);
    }

    /**
     * Clear the <code>java.lang.StringBuffer</code>
     * 
     * @param sb
     */
    protected static void clear(StringBuilder sb) {
        sb.delete(0, sb.length());
    }

    /**
     * Get an operator
     * 
     * @param symbol
     *            operator symbol
     * @return
     */
    protected Operator getOperator(String symbol) {
        return operatorMap.get(symbol);
    }

}
