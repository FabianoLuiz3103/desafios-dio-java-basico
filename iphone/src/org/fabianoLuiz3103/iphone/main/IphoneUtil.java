package org.fabianoLuiz3103.iphone.main;

import org.fabianoLuiz3103.iphone.model.Iphone;

import java.util.InputMismatchException;
import java.util.Scanner;

class IphoneUtil {

    protected static int receberInteiro(Scanner scanner, String texto){
        while (true){
            try{
                System.out.println("\n" + texto + "\n");
                int v = scanner.nextInt();
                scanner.nextLine();
                return v;
            }catch (InputMismatchException e ){
                System.out.println("\n\tERRO! O valor deve ser um número inteiro!");
                scanner.nextLine();
            }
        }
    }

    protected static int menuPrincipal(Scanner scanner){
        return receberInteiro(scanner, " >>>> INFORME <<<< " +
                "\n(1) Para ligar o iphone;" +
                "\n(2) Para desbloquear o iphone;" +
                "\n(3) Para abrir o reprodutor musical;" +
                "\n(4) Para abrir o navegador web;" +
                "\n(5) Para abrir o telefone;" +
                "\n(6) Para desligar o iphone;");
    }

    private static int menuTelefone(Scanner scanner){
        return receberInteiro(scanner, " >>>> INFORME <<<< " +
                "\n(1) Para fazer ligação;" +
                "\n(2) Para atender ligação" +
                "\n(3) Para sair.");
    }

    protected static void telefone(Scanner s, Iphone iphone){
        int menuT;
        try{
            do{
                menuT = menuTelefone(s);
                switch (menuT){
                    case 1 -> {
                        System.out.println("\nInforme o telefone que deseja fazer a ligação:");
                        String telefone = s.nextLine();
                        iphone.fazerLigacao(telefone);
                    }
                    case 2 -> iphone.atenderLigacao();
                    case 3 -> System.out.println("\n\t\tSaindo do telefone... ");
                    default -> System.out.println("\n\t\tOpção inválida...");
                }
            }while (menuT != 3);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static int menuNavegador(Scanner scanner){
        return receberInteiro(scanner, " >>>> INFORME <<<< " +
                "\n(1) Para carregar página;" +
                "\n(2) Para adicionar página em branco;" +
                "\n(3) Para sair.");
    }

    protected static void navegador(Scanner s, Iphone iphone){
        int menuN;
        try{
            do{
                menuN = menuNavegador(s);
                switch (menuN){
                    case 1 -> {
                        System.out.println("\nInforme a url da página que deseja:");
                        String url = s.nextLine();
                        iphone.exibirPagina(url);
                    }
                    case 2 -> iphone.adicionarPagina();
                    case 3 -> System.out.println("\n\t\tSaindo do navegador... ");
                    default -> System.out.println("\n\t\tOpção inválida...");
                }
            }while (menuN != 3);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static int menuMusical(Scanner scanner){
        return receberInteiro(scanner, " >>>> INFORME <<<< " +
                "\n(1) Para escolher musica;" +
                "\n(2) Para tocar musica;" +
                "\n(3) Para pausar musica;" +
                "\n(4) Para sair.");
    }

    protected static void reprodutorMusical(Scanner s, Iphone iphone){
        int menuM;
        try{
            do{
                menuM = menuMusical(s);
                switch (menuM){
                    case 1 -> {
                        System.out.println("\nInforme a música que deseja:");
                        String musica = s.nextLine();
                        iphone.selecionarMusica(musica);
                    }
                    case 2 -> iphone.tocarMusica();
                    case 3 -> iphone.pausarMusica();
                    case 4 -> System.out.println("\n\t\tSaindo do reprodutor musical... ");
                    default -> System.out.println("\n\t\tOpção inválida...");
                }
            }while (menuM != 4);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
