package org.fabianoLuiz3103.iphone.model;

import org.fabianoLuiz3103.iphone.exception.IphoneBloqueadoException;
import org.fabianoLuiz3103.iphone.exception.IphoneDesligadoException;
import org.fabianoLuiz3103.iphone.exception.MusicaNaoEscolhidaException;
import org.fabianoLuiz3103.iphone.model.navegador.NavegadorInternet;

public class Iphone implements ReprodutorMusical, AparelhoTelefonico, NavegadorInternet {

    private final String modelo;
    private final int armazenamento;
    private final Cor cor;
    private boolean ligado;
    private boolean desbloqueado;

    public Iphone(String modelo, int armazenamento, Cor cor) {
        this.modelo = modelo;
        this.armazenamento = armazenamento;
        this.cor = cor;
        this.ligado = false;
        this.desbloqueado = false;
    }

    public String getModelo() {
        return modelo;
    }

    public int getArmazenamento() {
        return armazenamento;
    }

    public Cor getCor() {
        return cor;
    }

    public boolean isLigado() {
        return ligado;
    }

    public boolean isDesbloqueado() {
        return desbloqueado;
    }

    public void ligaDesliga(){
        System.out.println(
                isLigado() ? "Desligando iphone..." : "Ligando iphone..."
        );
        this.ligado = !isLigado();
    }

    public void desbloquear() throws IphoneDesligadoException {
        if(!isLigado()){
            throw new IphoneDesligadoException();
        }
        this.desbloqueado = true;
        System.out.println("Desbloqueando iphone...");
    }

    @Override
    public void fazerLigacao(String telefone) throws IphoneDesligadoException, IphoneBloqueadoException {
        validacaoLigadoDesbloqueado("Iphone bloquedo!" +
                "\nSomente chamadas de emergência são permitidas.");
        System.out.println("Fazendo ligação para o número: " + telefone);
    }

    @Override
    public void atenderLigacao() throws IphoneDesligadoException {
        if(!isLigado()){
            throw new IphoneDesligadoException();
        }
        System.out.println("Atendendo ligação recebida...");
    }

    @Override
    public void tocarMusica() throws IphoneDesligadoException, IphoneBloqueadoException, MusicaNaoEscolhidaException {
       validacaoLigadoDesbloqueado("Iphone bloqueado!" +
               "\nNão foi possível reproduzir a música...");
       String musica = musicaEscolhida[0];
       if(musica == null){
           throw new MusicaNaoEscolhidaException();
       }
        System.out.println("Tocando a música: " + musica);
    }

    @Override
    public void pausarMusica() throws IphoneDesligadoException, IphoneBloqueadoException, MusicaNaoEscolhidaException {
        validacaoLigadoDesbloqueado("Iphone bloqueado!" +
                "\nNão foi possível pausar a música...");
        String musica = musicaEscolhida[0];
        if(musica == null){
            throw new MusicaNaoEscolhidaException();
        }
        System.out.println("Pausando a música: " + musica);
    }

    @Override
    public void selecionarMusica(String musica) throws IphoneDesligadoException, IphoneBloqueadoException {
        validacaoLigadoDesbloqueado("Iphone bloqueado!" +
                "\nNão foi possível escolher a música...");
        armazenarMusica(musica);
        System.out.println("Música escolhida: " + musica);

    }

    @Override
    public void exibirPagina(String url) throws IphoneDesligadoException, IphoneBloqueadoException {
        validacaoLigadoDesbloqueado("Iphone bloqueado!" +
                "\nNão foi possível exibir a página web...");
        System.out.println("Exibindo a página: " + url);
    }

    public String getInfos() throws IphoneDesligadoException, IphoneBloqueadoException {
        validacaoLigadoDesbloqueado("Iphone bloqueado!" +
                "\nNão foi possível exibir infos do seu celular");
        return ">> My Iphone <<" +
                "\n- Modelo: " + modelo +
                "\n- Armazenamento: " + armazenamento + "GB" +
                "\n- Cor: " + cor;
    }

    public void validacaoLigadoDesbloqueado(String mensagem) throws IphoneDesligadoException, IphoneBloqueadoException {
        if(!isLigado()){
            throw new IphoneDesligadoException();
        }
        if(!isDesbloqueado()){
            throw new IphoneBloqueadoException(mensagem);
        }
    }
}
