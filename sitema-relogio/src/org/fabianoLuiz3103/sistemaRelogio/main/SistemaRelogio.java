package org.fabianoLuiz3103.sistemaRelogio.main;


import org.fabianoLuiz3103.sistemaRelogio.exception.ValorInvalidoException;
import org.fabianoLuiz3103.sistemaRelogio.model.Relogio;
import org.fabianoLuiz3103.sistemaRelogio.model.RelogioBRL;
import org.fabianoLuiz3103.sistemaRelogio.model.RelogioUS;

public class SistemaRelogio {

    public static void main(String[] args)  {

        try{
            Relogio us = new RelogioUS();
            Relogio br = new RelogioBRL();

            br.setHora(15);
            br.setMinuto(30);
            br.setSegundo(45);
            System.out.println("\n\t\tRelógio BRL: " + br.getTime());

            us.setHora(17);
            us.setMinuto(55);
            us.setSegundo(10);
            System.out.println("\n\t\tRelógio US: " + us.getTime());

            System.out.println("\n\t\tBRL to US " + new RelogioUS().convert(br).getTime());

            System.out.println("\n\t\tUS to BRL " + new RelogioBRL().convert(us).getTime());
        }catch (ValorInvalidoException e){
            System.out.println(e.getMessage());
        }

    }
}
