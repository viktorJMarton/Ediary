package com.epam.ediary.service;

public class AuthenticationException extends Exception {
    public AuthenticationException() {
        System.out.println("\n Login name and/or password not valid");
    }
}
