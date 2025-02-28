package model;

public sealed class Ingresso permits MeiaEntrada, IngressoFamilia {

    private final double valor;
    private final String nomeDoFilme;
    private final Audio tipoAudio;

    public Ingresso(double valor, String nomeDoFilme, Audio tipoAudio) {
        this.valor = valor;
        this.nomeDoFilme = nomeDoFilme;
        this.tipoAudio = tipoAudio;
    }

    public double getValor() {
        return valor;
    }

    public String getNomeDoFilme() {
        return nomeDoFilme;
    }

    public Audio getTipoAudio() {
        return tipoAudio;
    }
}
