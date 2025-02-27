package org.fabianoLuiz3103.sistemaBancario.main;


import org.fabianoLuiz3103.sistemaBancario.exception.BoletoInvalidoException;
import org.fabianoLuiz3103.sistemaBancario.exception.DepositoInvalidoException;
import org.fabianoLuiz3103.sistemaBancario.exception.SemSaldoException;
import org.fabianoLuiz3103.sistemaBancario.model.Boleto;
import org.fabianoLuiz3103.sistemaBancario.model.Conta;
import org.fabianoLuiz3103.sistemaBancario.model.pessoa.Cliente;
import org.fabianoLuiz3103.sistemaBancario.model.pessoa.Gerente;
import org.fabianoLuiz3103.sistemaBancario.model.pessoa.Pessoa;
import org.fabianoLuiz3103.sistemaBancario.util.Menu;
import org.fabianoLuiz3103.sistemaBancario.util.Validora;

import java.util.Scanner;

public class OperacaoBanco {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Pessoa gerente = new Gerente("Antônio Lopes", "538.245.768-89", 56, "(11)97370-9981", "AL0921");
        Pessoa cliente = new Cliente("Fabiano Luiz", "538.255.799-90", 21, "(11)97370-0082", "Av. Ulisses Guimarães, 1206");
        Conta conta = new Conta(cliente, gerente, "49032-6", 600);

        int opcaoSelecionada;
        do{
            opcaoSelecionada = Menu.menuOpcoes(scanner);

            switch (opcaoSelecionada){
                case 1 -> System.out.println(conta.consultarSaldo());
                case 2 -> System.out.println("Seu cheque especial é de R$" + conta.getChequeEspecial());
                case 3 -> {
                    try {
                        double valorASerDepositado = Validora.validarNumero(scanner, "Informe o valor a ser depositado", false);
                        conta.depositar(valorASerDepositado);
                        System.out.println(conta.consultarSaldo());
                    }catch (DepositoInvalidoException e){
                        System.out.println(e.getMessage());
                    }
                }
                case 4 -> {
                    try{
                        double valorASerSacado = Validora.validarNumero(scanner, "Informe o valor a ser sacado", false);
                        conta.sacar(valorASerSacado);
                        System.out.println(conta.consultarSaldo());
                    }catch (SemSaldoException e){
                        System.out.println(e.getMessage());
                    }
                }
                case 5 -> {
                    try{
                        scanner.nextLine();
                        System.out.println("Informe o código do boleto:");
                        String codigoBoleto = scanner.nextLine();
                        double valorBoleto = Validora.validarNumero(scanner, "Informe o valor do boleto",false);
                        Boleto boleto = new Boleto(codigoBoleto, valorBoleto);
                        conta.pagarBoleto(boleto);
                        System.out.println("\n\t\tBoleto pago com sucesso!");
                        System.out.println(conta.consultarSaldo());
                    }catch (BoletoInvalidoException | SemSaldoException e){
                        System.out.println(e.getMessage());
                    }

                }
                case 6 -> System.out.println(conta.consultarUsoChequeEspecial());
                case 7 -> System.out.println("Você está devendo: R$" + conta.getTaxaUsoChequeEspecial());
                case 0 -> System.out.println("Até logo!");
                default -> System.out.println("Opção inválida!");
            }

        }while (opcaoSelecionada != 0);

        scanner.close();
    }

}
