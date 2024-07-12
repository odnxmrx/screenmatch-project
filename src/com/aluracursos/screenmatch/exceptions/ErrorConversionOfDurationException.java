package com.aluracursos.screenmatch.exceptions;

public class ErrorConversionOfDurationException extends RuntimeException {
    private String message;

    public ErrorConversionOfDurationException(String myMessage) {
        //'myMessage' es el mensaje que le dimos al crear esta excepcion
        this.message = myMessage;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
