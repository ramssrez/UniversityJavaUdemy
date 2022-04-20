package com.ramssrez.app.exceptions;

public class MateriasNotFoundException extends RuntimeException{
    public MateriasNotFoundException (String mensaje){
        super(mensaje);
    }
}
