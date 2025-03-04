package org.fabianoLuiz3103.iphone.main;

import org.fabianoLuiz3103.iphone.exception.IphoneBloqueadoException;
import org.fabianoLuiz3103.iphone.exception.IphoneDesligadoException;
import org.fabianoLuiz3103.iphone.model.Cor;
import org.fabianoLuiz3103.iphone.model.Iphone;

import java.util.Scanner;

public class IphoneMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Iphone iphone = new Iphone("Iphone 12", 264, Cor.BRANCO);
        int menuP;
        try{
        do{
            menuP = IphoneUtil.menuPrincipal(scanner);

            switch (menuP){

                case 1, 6 -> iphone.ligaDesliga();
                case 2 -> iphone.desbloquear();
                case 3 -> {
                    iphone.validacaoLigadoDesbloqueado("Iphone bloqueado!" +
                                "\nNão é possível abrir o reprodutor musical.");
                    IphoneUtil.reprodutorMusical(scanner, iphone);
                }
                case 4 -> {
                    iphone.validacaoLigadoDesbloqueado("Iphone bloqueado!" +
                            "\nNão é possível abrir o navegador.");
                     IphoneUtil.navegador(scanner, iphone);
                }
                case 5 -> {
                    iphone.validacaoLigadoDesbloqueado("Iphone bloqueado!" +
                            "\nNão é possível abrir o telefone.");
                    IphoneUtil.telefone(scanner, iphone);
                }
                default -> System.out.println("\n\tOpção inválida...");
            }
        }while (menuP != 6);
        }catch (IphoneDesligadoException |
        IphoneBloqueadoException e){
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
