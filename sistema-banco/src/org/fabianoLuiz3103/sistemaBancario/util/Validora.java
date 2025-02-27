package org.fabianoLuiz3103.sistemaBancario.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Validora {

    public static double validarNumero(Scanner scanner, String texto, boolean isMenu){
        while (true){
            try{
                System.out.println(texto);
                double valor = scanner.nextDouble();
                if(isMenu){
                    if(!isDouble(valor)){
                        return valor;
                    }else{
                        System.out.println("\n\tERRO! O valor deve ser um inteiro! ");
                        continue;
                    }
                }
                return valor;
            }catch (InputMismatchException e){
                System.out.println("\n\tERRO! O valor deve ser do tipo numérico! ");
                scanner.nextLine();
            }
        }
    }

    private static boolean isDouble(double valor){
        return valor%1 != 0;
    }
}
