package br.com.fabianoLuiz3103.model;

public class ContaTerminal {

    private int numero;
    private String agencia;
    private String nomeCliente;
    private double saldo;

    public ContaTerminal() {
    }

    public ContaTerminal(int numero, String agencia, String nomeCliente, double saldo) {
        this.numero = numero;
        this.agencia = agencia;
        this.nomeCliente = nomeCliente;
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Olá ".concat(this.nomeCliente).concat(", obrigado por criar uma conta" +
                "em nosso banco, sua agência é ").concat(this.agencia).concat(", conta ")
                .concat(String.valueOf(this.numero)).concat(" e seu saldo de R$")
                .concat(String.valueOf(this.saldo)).concat(" já está disponível para saque!");
    }
}
