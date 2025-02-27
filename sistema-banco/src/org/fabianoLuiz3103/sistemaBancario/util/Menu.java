package org.fabianoLuiz3103.sistemaBancario.util;

import java.util.Scanner;

public class Menu {

    public static int menuOpcoes(Scanner scanner){
        return (int)Validora.validarNumero(scanner, "\n\n==============================================" +
                "\n\t\tDIGITE:" +
                "\n(1) - Para consultar saldo;" +
                "\n(2) - Para consultar cheque especial;" +
                "\n(3) - Para depositar dinheiro;" +
                "\n(4) - Para sacar dinheiro;" +
                "\n(5) - Para pagar boleto;" +
                "\n(6) - Para verificar se está usando cheque especial;" +
                "\n(7) - Para vericar quando está devendo de cheque especial;" +
                "\n(0) - Para sair.", true);
    }
}
