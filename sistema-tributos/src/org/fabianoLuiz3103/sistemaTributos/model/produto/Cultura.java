package org.fabianoLuiz3103.sistemaTributos.model.produto;

public final class Cultura extends Produto{

    public Cultura(String nome, double preco) {
        super(nome, preco);
    }

    @Override
    public double valorDeImposto() {
        return super.getPreco() * 0.04;
    }
}
