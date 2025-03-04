package org.fabianoLuiz3103.iphone.exception;

public class MusicaNaoEscolhidaException extends Exception{
    @Override
    public String getMessage() {
        return "Selecione uma música antes de tentar reproduzir!";
    }
}
