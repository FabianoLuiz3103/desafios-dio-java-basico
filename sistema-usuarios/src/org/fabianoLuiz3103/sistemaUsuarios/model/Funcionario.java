package org.fabianoLuiz3103.sistemaUsuarios.model;

import org.fabianoLuiz3103.sistemaUsuarios.exception.AtualizacaoException;
import org.fabianoLuiz3103.sistemaUsuarios.exception.LogadoException;
import org.fabianoLuiz3103.sistemaUsuarios.exception.LoginInvalidoException;

public abstract class Funcionario {

    private String nome;
    private String email;
    private String senha;
    private final boolean isAdministrador;
    private boolean isLogado;

    public Funcionario(String nome, String email, String senha, boolean isAdministrador) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.isAdministrador = isAdministrador;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAdministrador() {
        return isAdministrador;
    }

    public boolean isLogado() {
        return isLogado;
    }

    public void realizarLogin(String email, String senha) throws LogadoException, LoginInvalidoException{
        if(this.isLogado){
            throw new LogadoException("\n\tVocê já está logado!");
        }
        if(this.email.equalsIgnoreCase(email) && this.senha.equals(senha)){
            this.isLogado = true;
            return;
        }
        throw new LoginInvalidoException("\n\tERRO! Credenciais inválidas!");
    }

    public void realizarLogoff() throws LogadoException{
      if(!this.isLogado){
          throw new LogadoException("\n\tVocê não está logado!");
      }
      this.isLogado = false;
    }

    public void alterarDados(String nome, String email) throws AtualizacaoException {
        if(nome.isBlank() || email.isBlank()){
            throw new AtualizacaoException("\n\tERRO! Dados inválidos!");
        }
        this.nome = nome;
        this.email = email;
    }

    public void alterarSenha(String senha) throws AtualizacaoException{
        if(senha.length() < 6 || senha.length() > 12){
            throw new AtualizacaoException("\n\tERRO! A senha deve ter entre 6 e 12 caracteres!");
        }
        this.senha = senha;
    }
}
