package co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class HorarioDeTrabajo implements ValueObject<String> {

    private final String horario;

    public HorarioDeTrabajo(String horario) {
        this.horario = Objects.requireNonNull(horario);

        if (this.horario.isBlank() || this.horario.isEmpty()) {
            throw new IllegalArgumentException("La cantidad de usuarios no puede estar en blanco o vacio");
        }
    }

    public static HorarioDeTrabajo of(String horario) {
        return new HorarioDeTrabajo(horario);
    }

    @Override
    public String value() {
        return horario;
    }
}
