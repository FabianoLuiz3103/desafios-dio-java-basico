package org.fabianoLuiz3103.figurasGeometricas.model.figuras;

import org.fabianoLuiz3103.figurasGeometricas.model.FiguraGeometrica;

public record Retangulo(double base, double altura) implements FiguraGeometrica {

    @Override
    public double calcularArea() {
        return base * altura;
    }
}
