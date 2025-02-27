package org.fabianoLuiz3103.sistemaBancario.model.pessoa;

public class Gerente extends Pessoa{

    private String codigoAcesso;

    public Gerente(String nome, String cpf, int idade, String telefone, String codigoAcesso) {
        super(nome, cpf, idade, telefone);
        this.codigoAcesso = codigoAcesso;
    }

    public String getCodigoAcesso() {
        return codigoAcesso;
    }

    public void setCodigoAcesso(String codigoAcesso) {
        this.codigoAcesso = codigoAcesso;
    }
}
