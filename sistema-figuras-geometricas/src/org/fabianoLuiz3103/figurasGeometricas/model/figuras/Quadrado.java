package org.fabianoLuiz3103.figurasGeometricas.model.figuras;

import org.fabianoLuiz3103.figurasGeometricas.model.FiguraGeometrica;

public record Quadrado(double lado) implements FiguraGeometrica {

    @Override
    public double calcularArea() {
        return Math.pow(lado,2);
    }
}
