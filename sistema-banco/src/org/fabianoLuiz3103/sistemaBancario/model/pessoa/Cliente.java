package org.fabianoLuiz3103.sistemaBancario.model.pessoa;


public class Cliente extends Pessoa{

    public Cliente(String nome, String cpf, int idade, String telefone, String endereco) {
        super(nome, cpf, idade, telefone);
        this.endereco = endereco;
    }

    private final String endereco;

    public String getEndereco() {
        return endereco;
    }
}
