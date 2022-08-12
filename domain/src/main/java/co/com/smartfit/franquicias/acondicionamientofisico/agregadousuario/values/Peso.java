package co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Peso implements ValueObject<Double> {

    private final Double peso;

    public Peso(Double peso) {
        this.peso = Objects.requireNonNull(peso);

        if (this.peso <= 0) {
            throw new IllegalArgumentException("El peso no debe ser cero o un valor negativo");
        }

        if (String.valueOf(this.peso).isBlank()) {
            throw new IllegalArgumentException("El peso no debe estar en blanco");
        }
    }

    public static Peso of(Double peso) {
        return new Peso(peso);
    }

    @Override
    public Double value() {
        return peso;
    }
}
