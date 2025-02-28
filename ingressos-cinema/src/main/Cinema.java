package main;

import model.Audio;
import model.Ingresso;
import model.IngressoFamilia;
import model.MeiaEntrada;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {

        var scanner = new Scanner(System.in);
        Ingresso ingresso = new Ingresso(20, "Capitão américa 4", Audio.DUBLADO);
        Ingresso meia = new MeiaEntrada(ingresso);
        Ingresso familia = new IngressoFamilia(ingresso);

        int opcMenu;
        do{
            opcMenu = menu(scanner);
            switch (opcMenu){
                case 1 -> imprimirIngressos(ingresso);
                case 2 -> imprimirIngressos(meia);
                case 3 -> {
                    int quantidadePessoas = receberInteiro(scanner, "Quantas pessoas irão? ");
                    System.out.println(quantidadePessoas>3 ? "Foi aplicado um desconto de 5% no valor final! " : "");
                    imprimirIngressos(familia,quantidadePessoas);
                }
                case 4 -> System.out.println("Até logo!");
                default -> System.out.println("Opção inválida!");
            }
        }while (opcMenu != 4);
    }
    private static int menu(Scanner scanner){
        return receberInteiro(scanner, "\n" +
                "\t\tINFORME:" +
                "\n(1) Para consultar valor do ingresso comum;" +
                "\n(2) Para consultar valor da meia entrada;" +
                "\n(3) Para consultar valor do ingresso família;" +
                "\n(4) Para sair.");
    }
    private static int receberInteiro(Scanner scanner, String texto){
        while (true){
            try{
                System.out.println(texto);
                int valor = scanner.nextInt();
                if(valor > 0){return valor;}
                System.out.println("\n\tERRO! O valor deve ser maior que zero! ");
            }catch (InputMismatchException e){
                System.out.println("\n\tERRO! O valor deve ser um número inteiro! ");
                scanner.nextLine();
            }
        }
    }
    private static void imprimirIngressos(Ingresso ingresso){
        switch (ingresso){
            case MeiaEntrada meia -> {
                System.out.println("Meia entrada para o filme: " + ingresso.getNomeDoFilme() + " - R$" + ingresso.getValor());
            }
            case Ingresso  comum ->{
                System.out.println("Ingresso comum para o filme: " + ingresso.getNomeDoFilme() + " - R$" + ingresso.getValor());
            }
        }
    }
    private static void imprimirIngressos(Ingresso ingresso, int quantidadePessoas){
        if(!(ingresso instanceof IngressoFamilia familia)){
            throw new IllegalStateException("Ingresso inválido!");
        }
            familia.setQuantidadePessoas(quantidadePessoas);
            System.out.println("Ingresso família para " + quantidadePessoas
                    + " pessoa para o filme: " + ingresso.getNomeDoFilme() + " - R$" + ingresso.getValor());
    }
}
