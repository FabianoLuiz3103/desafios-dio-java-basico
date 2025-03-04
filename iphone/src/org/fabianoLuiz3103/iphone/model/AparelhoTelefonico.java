package org.fabianoLuiz3103.iphone.model;

import org.fabianoLuiz3103.iphone.exception.IphoneBloqueadoException;
import org.fabianoLuiz3103.iphone.exception.IphoneDesligadoException;

public interface AparelhoTelefonico {

    void fazerLigacao(String telefone) throws IphoneDesligadoException, IphoneBloqueadoException;
    void atenderLigacao() throws IphoneDesligadoException;

    default void chamadaDeEmergia(){
        System.out.println("Ligando para o 190...");
    }
}
