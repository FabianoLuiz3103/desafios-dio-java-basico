package model;

public final class IngressoFamilia extends Ingresso{

    private int quantidadePessoas;

    public IngressoFamilia(Ingresso ingresso) {
        super(ingresso.getValor(), ingresso.getNomeDoFilme(), ingresso.getTipoAudio());
    }

    public int getQuantidadePessoas() {
        return quantidadePessoas;
    }

    public void setQuantidadePessoas(int quantidadePessoas) {
        this.quantidadePessoas = quantidadePessoas;
    }

    @Override
    public double getValor() {
        if(this.quantidadePessoas > 3){
            return calcularIngressoComDesconto(this.quantidadePessoas*super.getValor());
        }
        return super.getValor()*this.quantidadePessoas;
    }

    private double calcularIngressoComDesconto(double valor){
        return valor - (valor*0.05);
    }
}
