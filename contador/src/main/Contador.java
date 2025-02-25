package main;

import exception.ParametrosInvalidosException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Contador {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while(true){
            int i = receberInteiro(scanner, "início");
            int f = receberInteiro(scanner, "fim");
            try {
                contar(i,f);
                break;
            } catch (ParametrosInvalidosException e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();

    }

    private static int receberInteiro(Scanner scanner, String tipo){
        while (true){
            try{
                System.out.print("\n\tInforme o " + tipo + ": ");
                return scanner.nextInt();
            }catch (InputMismatchException e){
                System.out.println("\n\tERRO! O Valor deve ser do tipo numérico! ");
                scanner.nextLine();
            }
        }
    }

    private static void contar(int inicio, int fim) throws ParametrosInvalidosException {
        if(inicio > fim){
            throw new ParametrosInvalidosException("\n\t\tERRO! O início não pode ser maior que o final! ");
        }
        System.out.println("\n\nSEQUÊNCIA NUMÉRICA DE " + inicio + " ATÉ " + fim + ":");
        for(int i = inicio; i <= fim; i++){
            System.out.print(i + (i==fim?".":","));
        }
    }
}
