package co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;


public class Altura implements ValueObject<Double> {

    private final Double altura;

    public Altura(Double altura) {
        this.altura = Objects.requireNonNull(altura);

        if (this.altura <= 0) {
            throw new IllegalArgumentException("El peso no debe ser cero o un valor negativo");
        }

        if (String.valueOf(this.altura).isBlank()) {
            throw new IllegalArgumentException("El peso no debe estar en blanco");
        }
    }

    public static Altura of(Double altura) {
        return new Altura(altura);
    }

    @Override
    public Double value() {
        return altura;
    }
}