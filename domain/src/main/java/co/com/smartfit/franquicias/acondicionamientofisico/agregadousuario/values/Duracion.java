package co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Duracion implements ValueObject<Integer> {

    private final Integer duracion;

    public Duracion(Integer duracion) {

        this.duracion = Objects.requireNonNull(duracion);

        if (this.duracion <= 29) {
            throw new IllegalArgumentException("La duración de la clase no debe ser inferior a 30 minutos");
        }

        if (String.valueOf(this.duracion).isBlank()) {
            throw new IllegalArgumentException("La duración de la clase no debe estar en blanco");
        }
    }

    public static Duracion of(Integer duracion) {
        return new Duracion(duracion);
    }

    @Override
    public Integer value() {
        return duracion;
    }
}
