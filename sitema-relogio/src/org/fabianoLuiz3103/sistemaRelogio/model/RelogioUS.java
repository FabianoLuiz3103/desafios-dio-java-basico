package org.fabianoLuiz3103.sistemaRelogio.model;

import org.fabianoLuiz3103.sistemaRelogio.exception.ValorInvalidoException;


public final class RelogioUS extends Relogio{

    private String periodo;

    public String getPeriodo() {
        return periodo;
    }

    public void antesMeioDia(){
        this.periodo = "AM";
    }
    public void depoisMeioDia(){
        this.periodo = "PM";
    }

    @Override
    public void setHora(int hora) throws ValorInvalidoException{
        if(hora < 0 || hora > 24) {
            throw new ValorInvalidoException("\n\tERRO! Hora inválida!");
        }
        antesMeioDia();
        if(hora == 0 || hora == 24){
            super.hora = 12;
        }else if(hora >= 12 && hora < 24){
            super.hora = (hora==12)?12:hora-12;
            depoisMeioDia();
        }else{
            super.hora = hora;
        }
    }

    @Override
    public Relogio convert(Relogio relogio) throws ValorInvalidoException {
            this.minuto = relogio.getMinuto();
            this.segundo = relogio.getSegundo();
            switch (relogio){
                case RelogioBRL br ->  this.setHora(br.getHora());
                case RelogioUS us -> {
                    this.hora = us.getHora();
                    this.periodo = us.getPeriodo();
                }
            }
            return this;
    }

    @Override
    public String getTime() {
        return super.getTime() + " - " + this.periodo;
    }
}
