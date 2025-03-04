package org.fabianoLuiz3103.iphone.model.navegador;

import org.fabianoLuiz3103.iphone.exception.IphoneBloqueadoException;
import org.fabianoLuiz3103.iphone.exception.IphoneDesligadoException;

@FunctionalInterface
public interface NavegadorInternet{

    void exibirPagina(String url) throws IphoneDesligadoException, IphoneBloqueadoException;

    default void adicionarPagina(){
        ContadorPaginas.QUANTIDADE_PAGINAS+=1;
        System.out.println("Foi adicionado uma página no seu safari." +
                "\nAgora o número de páginas é: " + ContadorPaginas.QUANTIDADE_PAGINAS);
    }
}
