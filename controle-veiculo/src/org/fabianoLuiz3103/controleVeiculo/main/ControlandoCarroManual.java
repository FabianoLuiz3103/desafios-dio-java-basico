package org.fabianoLuiz3103.controleVeiculo.main;

import org.fabianoLuiz3103.controleVeiculo.exception.VeiculoDesligadoExcpetion;
import org.fabianoLuiz3103.controleVeiculo.exception.VelocidadeInvalidaException;
import org.fabianoLuiz3103.controleVeiculo.model.CarroManual;
import org.fabianoLuiz3103.controleVeiculo.model.Cor;
import java.util.Set;

public class ControlandoCarroManual {

    public static void main(String[] args) {

        CarroManual carro = new CarroManual("Fiat", "Argo", "ABC-123", Cor.LARANJA, 4);
        Set<Integer> velocidadesMaximas = Set.of(20,40,60,80,100,120);
        Set<Integer> velocidadesMinimas = Set.of(0,21,41,61,81,101);
        try {
            carro.ligar();
            carro.trocarMarcha();
            System.out.println("\n\n ---> ACELERANDO O CARRO <---");
            for(int i = 0; i < 120; i++){
                carro.acelerar();
                if(velocidadesMaximas.contains(i)){
                    carro.trocarMarcha();
                }
                System.out.println("Marcha: " + carro.getMarchaAtual() + "º velocidade: " + carro.verificarVelocidade() + "km/h");
            }

            System.out.println("\n\n ---> FREIANDO CARRO <---");
            for(int i = 120; i >= 0; i--){
                carro.desacelerar();
                if(velocidadesMinimas.contains(i)){
                    carro.trocarMarcha();
                }
                System.out.println("Marcha: " + carro.getMarchaAtual() + "º velocidade: " + carro.verificarVelocidade() + "km/h");
            }
        } catch (VelocidadeInvalidaException | VeiculoDesligadoExcpetion e) {
            System.out.println(e.getMessage());
        }
    }
}
