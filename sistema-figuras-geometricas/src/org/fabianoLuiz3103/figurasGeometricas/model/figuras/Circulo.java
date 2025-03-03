package org.fabianoLuiz3103.figurasGeometricas.model.figuras;

import org.fabianoLuiz3103.figurasGeometricas.model.FiguraGeometrica;

public record Circulo(double raio) implements FiguraGeometrica {

    @Override
    public double calcularArea() {
        return Math.PI * raio;
    }
}
