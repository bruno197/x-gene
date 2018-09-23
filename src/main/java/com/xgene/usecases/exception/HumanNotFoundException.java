package com.xgene.usecases.exception;

public class HumanNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 5502347862043183093L;

    public static final String MESSAGE = "Error to find human to database";

    public HumanNotFoundException() {
        super(MESSAGE);
    }
}
