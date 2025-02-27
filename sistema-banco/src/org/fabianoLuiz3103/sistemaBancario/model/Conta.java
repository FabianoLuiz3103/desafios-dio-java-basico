package org.fabianoLuiz3103.sistemaBancario.model;

import org.fabianoLuiz3103.sistemaBancario.exception.BoletoInvalidoException;
import org.fabianoLuiz3103.sistemaBancario.exception.DepositoInvalidoException;
import org.fabianoLuiz3103.sistemaBancario.exception.SemSaldoException;
import org.fabianoLuiz3103.sistemaBancario.model.pessoa.Pessoa;

public class Conta {

    private final Pessoa cliente;
    private final Pessoa gerente;
    private final String agencia;
    private final String numeroDaConta;
    private double saldo;
    private double chequeEspecial;
    private double taxaUsoChequeEspecial;
    private double valorUsadoChequeEspecial;

    public Conta(Pessoa cliente, Pessoa gerente, String numeroDaConta, double saldo) {
        this.cliente = cliente;
        this.gerente = gerente;
        this.agencia = "6511"; //simulando única agência bancária
        this.numeroDaConta = numeroDaConta;
        this.saldo = saldo;
        if(this.saldo > 500){
            this.chequeEspecial = (this.saldo*0.5);
        }else{
            this.chequeEspecial = 50.0;
        }
    }

    public Pessoa getCliente() {
        return cliente;
    }

    public Pessoa getGerente() {
        return gerente;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getNumeroDaConta() {
        return numeroDaConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public double getTaxaUsoChequeEspecial() {
        return taxaUsoChequeEspecial;
    }

    public void depositar(double valorAserDepositado) throws DepositoInvalidoException{
        if(valorAserDepositado < 0){
           throw new DepositoInvalidoException("\n\tDeposito inválido! Não é possível depositar valor negativo");
        }
        this.saldo += valorAserDepositado;
    }

    public void sacar(double valorAserSacado) throws SemSaldoException {
        double saldoTotal = this.saldo + this.chequeEspecial;
        if(valorAserSacado > saldoTotal){
            throw new SemSaldoException("\n\tSAQUE INDISPONÍVEL! SEU SALDO É DE: " + this.saldo);
        }
        if(this.saldo >= valorAserSacado){
            this.saldo -= valorAserSacado;
        }else{
            this.valorUsadoChequeEspecial = valorAserSacado-this.saldo;
            this.saldo = 0;
            this.chequeEspecial -= this.valorUsadoChequeEspecial;
            calcularTaxaChequeEspecial(valorUsadoChequeEspecial);
        }
    }

    private void calcularTaxaChequeEspecial(double valorUsadoChequeEspecial){
        this.taxaUsoChequeEspecial = valorUsadoChequeEspecial + (valorUsadoChequeEspecial * 0.2);
    }

    public void pagarBoleto(Boleto boleto) throws BoletoInvalidoException, SemSaldoException {

        if(boleto.getCodigo().isEmpty()){
            throw new BoletoInvalidoException("\n\tERRO! Boleto inválido!");
        }
        this.sacar(boleto.getValor());
    }

    public String consultarUsoChequeEspecial(){
        return (this.valorUsadoChequeEspecial>0)?"O cheque especial está sendo usado. O valor usado foi de: R$"+this.valorUsadoChequeEspecial
                + " ainda resta R$" + this.chequeEspecial : "O cheque especial não está sendo usado, ainda resta R$" + this.chequeEspecial;
    }

    public String consultarSaldo(){
        return "O saldo da conta " + this.numeroDaConta + ", cliente " + this.cliente.getNome()
                + " é de R$" + this.saldo;
    }



}
