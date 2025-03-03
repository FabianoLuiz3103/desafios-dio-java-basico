package org.fabianoLuiz3103.sistemaTributos.model.produto;

import org.fabianoLuiz3103.sistemaTributos.model.Tributo;

public sealed abstract class Produto implements Tributo permits Alimentacao, Saude, Vestuario, Cultura{

    private final String nome;
    private final double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
       return "\n\tProduto: " + this.nome + " valor R$" + this.preco;
    }
}
