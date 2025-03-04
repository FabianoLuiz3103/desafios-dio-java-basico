package org.fabianoLuiz3103.iphone.exception;

public class IphoneDesligadoException extends Exception{
    @Override
    public String getMessage() {
        return "Operação inválida! Seu iphone está desligado.";
    }
}
