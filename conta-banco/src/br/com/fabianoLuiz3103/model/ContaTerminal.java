package br.com.fabianoLuiz3103.model;

/**
 * <h1>Conta terminal</h1>
 * A classe conta terminal realiza a criação de contas
 *
 * @author FabianoLuiz3103
 * @version 1.0
 * @since 21/02/2025
 */
public class ContaTerminal {

    private int numero;
    private String agencia;
    private String nomeCliente;
    private double saldo;

    public ContaTerminal() {
    }

    /**
     *
     * @param numero é o numéro da conta do cliente
     * @param agencia é o número da agência do cliente
     * @param nomeCliente é o nome completo do cliente
     * @param saldo é o saldo inicial da conta do cliente
     */
    public ContaTerminal(int numero, String agencia, String nomeCliente, double saldo) {
        this.numero = numero;
        this.agencia = agencia;
        this.nomeCliente = nomeCliente;
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Olá ".concat(this.nomeCliente).concat(", obrigado por criar uma conta" +
                " em nosso banco, sua agência é ").concat(this.agencia).concat(", conta ")
                .concat(String.valueOf(this.numero)).concat(" e seu saldo de R$")
                .concat(String.valueOf(this.saldo)).concat(" já está disponível para saque!");
    }
}
