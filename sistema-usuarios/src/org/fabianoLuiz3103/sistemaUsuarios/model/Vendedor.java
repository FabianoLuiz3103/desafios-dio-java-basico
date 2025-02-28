package org.fabianoLuiz3103.sistemaUsuarios.model;

public class Vendedor extends Funcionario implements Vendas {

    private int quantidadeVendas;

    public Vendedor(String nome, String email, String senha) {
        super(nome, email, senha, false);
    }

    @Override
    public String consultarVendas() {
        return null;
    }

    public void realizarVenda(){
        this.quantidadeVendas+=1;
    }
}
