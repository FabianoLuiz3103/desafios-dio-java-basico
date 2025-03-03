package org.fabianoLuiz3103.figurasGeometricas.main;


import org.fabianoLuiz3103.figurasGeometricas.model.FiguraGeometrica;
import org.fabianoLuiz3103.figurasGeometricas.model.figuras.Circulo;
import org.fabianoLuiz3103.figurasGeometricas.model.figuras.Quadrado;
import org.fabianoLuiz3103.figurasGeometricas.model.figuras.Retangulo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        FiguraGeometrica figuraGeometrica = null;
        int opcaoMenu;
        do{
            opcaoMenu = menu(scanner);
            if(opcaoMenu == 1){
                figuraGeometrica = criarQuadrado(scanner);
                break;
            }else if(opcaoMenu == 2){
                figuraGeometrica = criarRetangulo(scanner);
                break;
            }else if(opcaoMenu == 3){
                figuraGeometrica = criarCirculo(scanner);
                break;
            }else if(opcaoMenu == 4){
                System.out.println("Até logo");
            }else{
                System.out.println("Opção inválida");
            }
        } while (opcaoMenu != 4);
        System.out.println("O resultado do cálculo foi: " + (figuraGeometrica != null ? figuraGeometrica.calcularArea() : 0));

        scanner.close();
    }


    private static Quadrado criarQuadrado(Scanner scanner){
        double lado = lerNumero(scanner, "Informe o lado do quadrado", false);
        return new Quadrado(lado);
    }
    private static Retangulo criarRetangulo(Scanner scanner){
        double base = lerNumero(scanner, "Informe a base do retângulo", false);
        double altura = lerNumero(scanner, "Informe a altura do retângulo", false);
        return new Retangulo(base, altura);
    }
    private static Circulo criarCirculo(Scanner scanner){
        double raio = lerNumero(scanner, "Informe o raio do círculo", false);
        return new Circulo(raio);
    }

    private static int menu(Scanner scanner){
        return (int) lerNumero(scanner,
                "\n\t\t >> INFORME A FIGURA PARA CALCULAR A ÁREA: <<" +
                        "\n(1) - Para quadrado; " +
                        "\n(2) - Para retângulo;" +
                        "\n(3) - Para circulo;" +
                        "\n(4) - Para sair.", true);
    }

    private static double lerNumero(Scanner scanner, String texto, boolean isMenu){
        while (true){
            try{
                System.out.println(texto);
                double valor = scanner.nextDouble();
                if(isMenu){
                    if(!isDouble(valor)){
                        return valor;
                    }
                    System.out.println("\n\tERRO! O valor deve ser um inteiro!");
                    continue;
                }
                if(valor > 0){return valor;}
                System.out.println("\n\tERRO! O valor deve ser maior que zero! ");
            }catch (InputMismatchException e){
                System.out.println("\n\tERRO! O valor deve ser do tipo numérico! ");
                scanner.nextLine();
            }
        }
    }
    private static boolean isDouble(double numero){
        return numero % 1 != 0;
    }
}
