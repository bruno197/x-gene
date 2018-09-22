package com.xgene.gateways.exception;

public class GeneXDatabaseGatewayException extends RuntimeException {
    private static final long serialVersionUID = 5502347862043183093L;

    public static final String MESSAGE = "Error to save or read human to database";

    public GeneXDatabaseGatewayException() {
        super(MESSAGE);
    }
}
