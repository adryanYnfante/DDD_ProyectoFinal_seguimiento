package co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;


public class DiasALaborar implements ValueObject<String> {

    private final String dias;

    public DiasALaborar(String dias) {
        this.dias = Objects.requireNonNull(dias);

        if (this.dias.isBlank()) {
            throw new IllegalArgumentException("El telefono no puede estar vacio");
        }

        if (this.dias.length() >= 10) {
            throw new IllegalArgumentException("El telefono no permite mas de 10 caracteres");
        }

        if (this.dias.length() <= 0) {
            throw new IllegalArgumentException("El telefono no puede ser cero o negativo");
        }

    }

    public static DiasALaborar of(String dias) {
        return new DiasALaborar(dias);
    }

    @Override
    public String value() {
        return dias;
    }
}
