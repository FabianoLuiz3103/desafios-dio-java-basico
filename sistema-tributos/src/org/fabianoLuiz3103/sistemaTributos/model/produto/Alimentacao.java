package org.fabianoLuiz3103.sistemaTributos.model.produto;

public final class Alimentacao extends Produto{

    public Alimentacao(String nome, double preco) {
        super(nome, preco);
    }

    @Override
    public double valorDeImposto() {
        return super.getPreco() * 0.01;
    }
}
