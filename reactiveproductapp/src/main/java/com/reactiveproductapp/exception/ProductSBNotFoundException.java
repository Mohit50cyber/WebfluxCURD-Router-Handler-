package com.reactiveproductapp.exception;

public class ProductSBNotFoundException extends RuntimeException {

    public ProductSBNotFoundException(String message){
        super(message);
    }

    public ProductSBNotFoundException(){
        super();
    }
}
