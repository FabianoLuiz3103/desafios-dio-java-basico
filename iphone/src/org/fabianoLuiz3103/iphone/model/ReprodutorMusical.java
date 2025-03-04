package org.fabianoLuiz3103.iphone.model;

import org.fabianoLuiz3103.iphone.exception.IphoneBloqueadoException;
import org.fabianoLuiz3103.iphone.exception.IphoneDesligadoException;
import org.fabianoLuiz3103.iphone.exception.MusicaNaoEscolhidaException;

public interface ReprodutorMusical {

    String[] musicaEscolhida = new String[1];
    void tocarMusica() throws IphoneDesligadoException, IphoneBloqueadoException, MusicaNaoEscolhidaException;
    void pausarMusica() throws IphoneDesligadoException, IphoneBloqueadoException, MusicaNaoEscolhidaException;
    void selecionarMusica(String musica) throws IphoneDesligadoException, IphoneBloqueadoException;

    default void armazenarMusica(String musica){
        musicaEscolhida[0] = musica;
    }
}
