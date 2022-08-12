package co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Mensualidad implements ValueObject<Double> {
    private final Double mensualidad;

    public Mensualidad(Double mensualidad) {
        this.mensualidad = Objects.requireNonNull(mensualidad);

        if (this.mensualidad <= 0) {
            throw new IllegalArgumentException("El IMC no debe ser cero o un valor negativo");
        }

        if (String.valueOf(this.mensualidad).isBlank()) {
            throw new IllegalArgumentException("El IMC no debe estar en blanco");
        }
    }

    public static Mensualidad of(Double mensualidad) {
        return new Mensualidad(mensualidad);
    }

    @Override
    public Double value() {
        return mensualidad;
    }

}
