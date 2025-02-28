package org.fabianoLuiz3103.controleVeiculo.model;

import org.fabianoLuiz3103.controleVeiculo.exception.VeiculoDesligadoExcpetion;
import org.fabianoLuiz3103.controleVeiculo.exception.VelocidadeInvalidaException;

public class CarroManual extends Veiculo{

    private final  int[][] LIMITES = {//linha e coluna
            {1, 0, 20},    // 1ª marcha: 0-20 km/h
            {2, 21, 40},   // 2ª marcha: 21-40 km/h
            {3, 41, 60},   // 3ª marcha: 41-60 km/h
            {4, 61, 80},   // 4ª marcha: 61-80 km/h
            {5, 81, 100},  // 5ª marcha: 81-100 km/h
            {6, 101, 120}  // 6ª marcha: 101-120 km/h
    };

    private boolean pontoMorto;

    public CarroManual(String marca, String modelo, String placa, Cor cor, int quantidadeRodas) {
        super(marca, modelo, placa, cor, quantidadeRodas);
        this.pontoMorto = true;
    }

    private void verificarSeEstaLigado() throws VeiculoDesligadoExcpetion {
        if(!super.isLigado()){
            throw new VeiculoDesligadoExcpetion("ERRO! Carro desligado!");
        }
    }


    @Override
    public void ligar() {
        if(this.pontoMorto && !super.isLigado()){
            super.setLigado(true);
        }
    }

    @Override
    public void desligar() {
        if(this.pontoMorto && super.verificarVelocidade() == 0 && !super.isLigado()){
            super.setLigado(false);
        }
    }

    @Override
    public void acelerar() throws VelocidadeInvalidaException, VeiculoDesligadoExcpetion {
        verificarSeEstaLigado();
        operacaoAceleraDesacelera(true);
    }


    @Override
    public void desacelerar() throws VelocidadeInvalidaException, VeiculoDesligadoExcpetion {
        verificarSeEstaLigado();
        operacaoAceleraDesacelera(false);
    }

    @Override
    public void virarEsquerda() throws VelocidadeInvalidaException, VeiculoDesligadoExcpetion {
        verificarSeEstaLigado();
        operacaoVirarEsquerdaDireita();
        System.out.println("Virando para esquerda");
    }

    @Override
    public void virarDireita() throws VelocidadeInvalidaException, VeiculoDesligadoExcpetion {
        verificarSeEstaLigado();
        operacaoVirarEsquerdaDireita();
        System.out.println("Virando para direita");
    }

    @Override
    public void trocarMarcha() throws VelocidadeInvalidaException, VeiculoDesligadoExcpetion {
        verificarSeEstaLigado();
        int marcha = super.getMarchaAtual();
        int velocidade = super.verificarVelocidade();

        if(marcha == 0){ //passando para primeira marcha
            this.pontoMorto=false;
            super.setMarchaAtual(1);
            return;
        }
        if(marcha == 1 && velocidade == 0){//jogando no ponto morto
            this.pontoMorto = true;
            super.setMarchaAtual(0);
            return;
        }
        if(marcha == 6 && velocidade > 120){
            return;
        }

        for (int[] limite : LIMITES) {//correndo nas linhas
            if (marcha == limite[0]) {
                if(velocidade > limite[2]){
                    super.setMarchaAtual(marcha+1);
                    return;
                }else if (velocidade < limite[1]){
                    super.setMarchaAtual(marcha-1);
                    return;
                }else{
                    throw new VelocidadeInvalidaException("Velocidade inválida para troca de marcha!");
                }
            }
        }
    }

    private void operacaoVirarEsquerdaDireita() throws VelocidadeInvalidaException {
        int velocidade = super.verificarVelocidade();
        if(velocidade < 1 || velocidade > 40){
            throw new VelocidadeInvalidaException("Velocida inválida! Para virar o carro você deve estar entre 0km/h e 40km/h");
        }

    }

    private void operacaoAceleraDesacelera(boolean acelerando) throws VelocidadeInvalidaException{

        int velocidade = super.verificarVelocidade();
        int marcha = super.getMarchaAtual();


        for (int[] limite : LIMITES) {//correndo nas linhas
            if (marcha == limite[0]) {
                validarVelocidade(acelerando, velocidade, limite[1], limite[2], marcha);
                int novaVelocidade = (acelerando? velocidade+1:
                        (velocidade-1)==-1?0:(velocidade-1));
                super.setVelocidade(novaVelocidade);
                return;
            }
        }
    }

    private void validarVelocidade(boolean a, int v, int min, int max, int m) throws VelocidadeInvalidaException{
        if(a && m == 6 && v== 120){
            throw new VelocidadeInvalidaException(
                    "Velocidade inválida! A " + m + "ª marcha vai de " +
                            min + "km/h a " + max + "km/h"
            );
        }
        if (v < min || v > max) {
            throw new VelocidadeInvalidaException(
                    "Velocidade inválida! A " + m + "ª marcha vai de " +
                            min + "km/h a " + max + "km/h"
            );
        }
    }
}
