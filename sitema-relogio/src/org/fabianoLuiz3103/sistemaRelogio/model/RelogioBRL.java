package org.fabianoLuiz3103.sistemaRelogio.model;

public final class RelogioBRL extends Relogio{


    @Override
    public Relogio convert(Relogio relogio) {
        super.minuto = relogio.getMinuto();
        super.segundo = relogio.getSegundo();
       switch (relogio){
           case RelogioUS us -> {
               int hr = relogio.getHora();
               this.hora = (us.getPeriodo().equals("PM")? hr+12:
                       (hr==12) ? 0 : hr); //se for AM e for 12 ou seja meia noite
           }
           case RelogioBRL br -> this.hora = br.getHora();
       }
       return this;
    }
}
