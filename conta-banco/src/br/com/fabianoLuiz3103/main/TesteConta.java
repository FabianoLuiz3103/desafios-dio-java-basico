package br.com.fabianoLuiz3103.main;

import br.com.fabianoLuiz3103.model.ContaTerminal;

import java.util.InputMismatchException;
import java.util.Scanner;


public class TesteConta {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("\nInforme seu nome: ");
        String nome = scanner.nextLine();
        System.out.print("\nInforme sua agência: ");
        String agencia = scanner.next();
        int numeroConta = (int) validarNumero(scanner, true, "\nInforme o número da conta: ");
        double saldo = validarNumero(scanner, false, "\nInforme o saldo: ");
        if(!nome.isBlank() && !agencia.isBlank() && numeroConta != 0 && saldo != 0){
            ContaTerminal contaTerminal = new ContaTerminal(numeroConta, agencia, nome, saldo);
            System.out.println(contaTerminal);
        }else{
            System.out.println("\nFalha ao criar conta!");
        }
    }
    private static double validarNumero(Scanner scanner, boolean isInteiro, String texto){
        while (true){
            try{
                System.out.print(texto);
                double valor = scanner.nextDouble();
                if(isInteiro){
                    if(!isDouble(valor)){
                        return valor;
                    }else{
                        System.out.println("\nValor inválido! Deve ser um inteiro!");
                        continue;
                    }
                }
                return valor;
            }catch (InputMismatchException e){
                System.out.println("\nValor inválido. Deve ser um número!");
                scanner.nextLine();
            }
        }
    }
    private static boolean isDouble(double valor){
        return valor % 1 != 0;
    }
}
