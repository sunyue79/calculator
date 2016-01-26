/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 */
package com.sunyue.util.calculator.api;

/**
 * This class is used to indicate error during constructing calculation rules
 * and calculating expression.
 * 
 * @author sunyue05
 */
public class CalculationException extends RuntimeException {

    public CalculationException() {
        super();
    }

    public CalculationException(String message) {
        super(message);
    }

    public CalculationException(Throwable cause) {
        super(cause);
    }

    public CalculationException(String message, Throwable cause) {
        super(message, cause);
    }

}
