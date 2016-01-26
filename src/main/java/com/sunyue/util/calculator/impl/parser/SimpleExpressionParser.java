/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 */
package com.sunyue.util.calculator.impl.parser;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.sunyue.util.calculator.api.Bracket;
import com.sunyue.util.calculator.api.CalculationException;
import com.sunyue.util.calculator.api.Operator;

/**
 * This class is a simple expression parser. It can only support single letter
 * operator.
 * 
 * @author sunyue05
 */
public class SimpleExpressionParser extends AbstractExpressionParser {

    public SimpleExpressionParser(Operator[] operators) {
        super(operators);
    }

    public Object[] parse(String expression) {
        if (StringUtils.isBlank(expression)) {
            throw new CalculationException("Expression can not be blank");
        }
        char[] exp = expression.toCharArray();
        StringBuilder buffer = new StringBuilder(100);
        List<Object> result = new ArrayList<Object>();
        for (int i = 0; i < exp.length; i++) {
            String current = String.valueOf(exp[i]);
            if (AbstractExpressionParser.SPACE.equals(current)
                    || AbstractExpressionParser.COMMA.equals(current)) {
                // space or comma
                addToken(result, buffer.toString());
                clear(buffer);
            } else if (Bracket.LEFT_BRACKET.getSymbol().equals(current)) {
                // "("
                addToken(result, buffer.toString(), Bracket.LEFT_BRACKET);
                clear(buffer);
            } else if (Bracket.RIGHT_BRACKET.getSymbol().equals(current)) {
                // ")"
                addToken(result, buffer.toString(), Bracket.RIGHT_BRACKET);
                clear(buffer);
            } else if (isOperator(current)) {
                // operator
                addToken(result, buffer.toString(), getOperator(current));
                clear(buffer);
            } else {
                // other
                buffer.append(current);
            }
        }
        addToken(result, buffer.toString());
        return result.toArray();
    }

}
