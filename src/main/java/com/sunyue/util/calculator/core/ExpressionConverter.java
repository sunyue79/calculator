/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 */
package com.sunyue.util.calculator.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.apache.commons.lang.ArrayUtils;

import com.sunyue.util.calculator.api.Bracket;
import com.sunyue.util.calculator.api.CalculationException;
import com.sunyue.util.calculator.api.Operator;

/**
 * This class is used to convert an infix expression to a postfix expression.
 * 
 * @author sunyue05
 */
public abstract class ExpressionConverter {

    /**
     * Convert an infix expression to a postfix expression.
     * 
     * @param exp
     *            expression parsed by ExpressionParser
     * @return postfix expression
     */
    public static Object[] convert(Object[] exp) {
        if (ArrayUtils.isEmpty(exp)) {
            throw new CalculationException("Expression can not be empty");
        }
        // remember if brackets are coupled
        int coupled = 0;
        // out put postfix expression
        List<Object> out = new ArrayList<Object>();
        Stack<Object> opStack = new Stack<Object>();
        for (int i = 0; i < exp.length; i++) {
            if (exp[i] instanceof Operator) {
                // operator
                Operator op = (Operator) exp[i];
                while (true) {
                    if (opStack.isEmpty()) {
                        opStack.push(op);
                        break;
                    } else {
                        Object obj = opStack.peek();
                        if (!(obj instanceof Bracket)) {
                            Operator preOp = (Operator) opStack.peek();
                            if (op.getPriority() <= preOp.getPriority()) {
                                // pop and output operator with not lower
                                // priority
                                out.add(opStack.pop());
                            } else {
                                // push otherwise
                                opStack.push(op);
                                break;
                            }
                        } else {
                            // push when bracket on top
                            opStack.push(op);
                            break;
                        }
                    }
                }
            } else if (Bracket.LEFT_BRACKET.equals(exp[i])) {
                opStack.push(exp[i]);
                coupled++;
            } else if (Bracket.RIGHT_BRACKET.equals(exp[i])) {
                if (coupled <= 0) {
                    throw new CalculationException(
                            "Brackets are not coupled, missing left bracket (");
                }
                while (true) {
                    Object op = opStack.pop();
                    if (Bracket.LEFT_BRACKET.equals(op)) {
                        // eliminate coupled brackets
                        break;
                    } else {
                        // pop and output until coupled left bracket
                        out.add(op);
                    }
                }
                coupled--;
            } else {
                // general numbers
                out.add(exp[i]);
            }
        }
        if (coupled != 0) {
            throw new CalculationException(
                    "Brackets are not coupled, missing right bracket )");
        }
        // output rest elements
        while (!opStack.isEmpty()) {
            out.add(opStack.pop());
        }
        return out.toArray();
    }

}
