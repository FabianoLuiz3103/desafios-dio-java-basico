package org.fabianoLuiz3103.sistemaTributos.main;

import org.fabianoLuiz3103.sistemaTributos.model.produto.*;

public class Main {

    public static void main(String[] args) {

        Produto banana = new Alimentacao("Banana", 12);
        Produto ortopedista = new Saude("Ortopedista", 65.5);
        Produto calca = new Vestuario("Calça Jeans", 150);
        Produto cinema = new Cultura("Cinema", 25);

        imprimirTributoProduto(banana);
        imprimirTributoProduto(ortopedista);
        imprimirTributoProduto(calca);
        imprimirTributoProduto(cinema);

    }
    private static void imprimirTributoProduto(Produto produto){
        System.out.println(produto);
        switch (produto){
            case Alimentacao a -> System.out.println("Imposto para alimentação: 1% - R$" + a.valorDeImposto() + " de imposto! ");
            case Saude s -> System.out.println("Imposto para saúde: 1,5% - R$" + s.valorDeImposto() + " de imposto! ");
            case Vestuario v -> System.out.println("Imposto para vestuário: 2,5% - R$" + v.valorDeImposto() + " de imposto! ");
            case Cultura c -> System.out.println("Imposto para cultura: 4% - R$" + c.valorDeImposto() + " de imposto! ");
        }
    }
}
