package model;

public final class MeiaEntrada extends Ingresso{


    public MeiaEntrada(Ingresso ingresso) {
        super(ingresso.getValor(), ingresso.getNomeDoFilme(), ingresso.getTipoAudio());
    }

    @Override
    public double getValor() {
        return (super.getValor()/2);
    }
}
