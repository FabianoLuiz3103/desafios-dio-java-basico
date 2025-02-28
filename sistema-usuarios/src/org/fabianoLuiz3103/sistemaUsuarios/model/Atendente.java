package org.fabianoLuiz3103.sistemaUsuarios.model;

public class Atendente extends Funcionario{

    private double valorEmCaixa;

    public Atendente(String nome, String email, String senha) {
        super(nome, email, senha, false);
    }

    public void receberPagamentos(){
        this.valorEmCaixa+=1;
    }

    public String fecharOCaixa(){
        return "Valor após o caixa ser fechado: R$" + this.valorEmCaixa;
    }
}
