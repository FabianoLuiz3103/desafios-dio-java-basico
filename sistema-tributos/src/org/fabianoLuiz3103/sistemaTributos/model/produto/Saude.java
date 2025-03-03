package org.fabianoLuiz3103.sistemaTributos.model.produto;

public final class Saude extends Produto{

    public Saude(String nome, double preco) {
        super(nome, preco);
    }

    @Override
    public double valorDeImposto() {
        return super.getPreco() * 0.015;
    }
}
