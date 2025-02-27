package org.fabianoLuiz3103.sistemaBancario.model;

public class Boleto {

    private String codigo;
    private double valor;

    public Boleto(String codigo, double valor) {
        this.codigo = codigo;
        this.valor = valor;
    }

    public String getCodigo() {
        return codigo;
    }

    public double getValor() {
        return valor;
    }
}
