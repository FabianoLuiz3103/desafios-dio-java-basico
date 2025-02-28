package org.fabianoLuiz3103.sistemaRelogio.model;

import org.fabianoLuiz3103.sistemaRelogio.exception.ValorInvalidoException;

public sealed abstract class Relogio permits RelogioBRL, RelogioUS {

    protected int hora;
    protected int minuto;
    protected int segundo;

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) throws ValorInvalidoException {
        if(hora < 0 || hora > 24) {
            throw new ValorInvalidoException("\n\tERRO! Hora inválida!");
        }
        this.hora = hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) throws ValorInvalidoException {
        if(minuto < 0 || minuto > 59) {
            throw new ValorInvalidoException("\n\tERRO! Minuto inválido!");
        }
        this.minuto = minuto;
    }

    public int getSegundo() {
        return segundo;
    }

    public void setSegundo(int segundo) throws ValorInvalidoException {
        if(segundo < 0 || segundo > 59) {
            throw new ValorInvalidoException("\n\tERRO! Segundo inválido!");
        }
        this.segundo = segundo;
    }

    abstract Relogio convert(Relogio relogio) throws ValorInvalidoException;

    public String getTime() {
       return this.hora + ":" + this.minuto + ":" + this.segundo;
    }

}
