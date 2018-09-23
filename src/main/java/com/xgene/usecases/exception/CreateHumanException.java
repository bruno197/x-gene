package com.xgene.usecases.exception;

public class CreateHumanException extends RuntimeException {
    private static final long serialVersionUID = 5502347862043183093L;

    public static final String MESSAGE = "Error to create human to database";

    public CreateHumanException() {
        super(MESSAGE);
    }

    public CreateHumanException(final String message) {
        super(message);
    }
}
