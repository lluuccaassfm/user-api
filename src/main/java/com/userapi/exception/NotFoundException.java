package com.userapi.exception;

public class NotFoundException extends Exception {

    private static final String NOT_FOUND_USER = "Nenhum usuário encontrado";

    public NotFoundException() {
        super(NOT_FOUND_USER);
    }
}
