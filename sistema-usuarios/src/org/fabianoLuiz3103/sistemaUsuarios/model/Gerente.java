package org.fabianoLuiz3103.sistemaUsuarios.model;

public class Gerente extends Funcionario implements Vendas{

    public Gerente(String nome, String email, String senha) {
        super(nome, email, senha, true);
    }

    public String gerarRelatorioFinanceiro(){
       return "Relatório de financeiro";
    }

    @Override
    public String consultarVendas() {
        return null;
    }
}
