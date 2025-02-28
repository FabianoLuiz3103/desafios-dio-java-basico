package org.fabianoLuiz3103.controleVeiculo.model;

import org.fabianoLuiz3103.controleVeiculo.exception.VeiculoDesligadoExcpetion;
import org.fabianoLuiz3103.controleVeiculo.exception.VelocidadeInvalidaException;

public abstract class Veiculo {

    private final String marca;
    private final String modelo;
    private final String placa;
    private final Cor cor;
    private final int quantidadeRodas;
    private boolean ligado;
    private int velocidade;
    private int marchaAtual;

    public Veiculo(String marca, String modelo, String placa, Cor cor, int quantidadeRodas) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.cor = cor;
        this.quantidadeRodas = quantidadeRodas;
        this.ligado = false;
        this.velocidade = 0;
        this.marchaAtual = 0;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public Cor getCor() {
        return cor;
    }

    public int getQuantidadeRodas() {
        return quantidadeRodas;
    }

    public boolean isLigado() {
        return ligado;
    }

    protected void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    protected void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public int getMarchaAtual() {
        return marchaAtual;
    }

    protected void setMarchaAtual(int marchaAtual) {
        this.marchaAtual = marchaAtual;
    }

    public abstract void ligar();
    public abstract void desligar();
    public abstract void acelerar() throws VelocidadeInvalidaException, VeiculoDesligadoExcpetion;
    public abstract void desacelerar() throws VelocidadeInvalidaException, VeiculoDesligadoExcpetion;
    public abstract void virarEsquerda()throws VelocidadeInvalidaException, VeiculoDesligadoExcpetion;
    public abstract void virarDireita()throws VelocidadeInvalidaException, VeiculoDesligadoExcpetion;
    public abstract void trocarMarcha() throws VelocidadeInvalidaException, VeiculoDesligadoExcpetion;

    public int verificarVelocidade(){
        return this.velocidade;
    }


}
