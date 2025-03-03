package org.fabianoLuiz3103.sistemaMensagem.main;

import org.fabianoLuiz3103.sistemaMensagem.model.ServicoMensagem;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        String mensagem = "Confira nossa nova promoção: 50% de desconto! ";

        ServicoMensagem sms = (msg) -> System.out.println("Enviando SMS: " + msg);
        ServicoMensagem email = (msg) -> System.out.println("Enviando o E-mail: " + msg);
        ServicoMensagem redesSociais = (msg) -> System.out.println("Enviando pelas redes sociais: " + msg);
        ServicoMensagem whatsApp = (msg) -> System.out.println("Enviando pelo WhatsApp: " + msg);

        List<ServicoMensagem> servicos = List.of(sms, email, redesSociais, whatsApp);

        dispararMensagens(mensagem, servicos);

    }

    public static void dispararMensagens(String mensagem, List<ServicoMensagem> servicoMensagens){
        for(ServicoMensagem s: servicoMensagens){
            s.enviarMensagem(mensagem);
        }
    }
}
