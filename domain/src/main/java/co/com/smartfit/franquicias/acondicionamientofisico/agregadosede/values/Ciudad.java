package co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Ciudad implements ValueObject<String> {
    private final String ciudad;

    public Ciudad(String ciudad) {

        this.ciudad = Objects.requireNonNull(ciudad);

        if (this.ciudad.isBlank()) {
            throw new IllegalArgumentException("El nombre de la ciudad no puede estar vacio");
        }

        if (this.ciudad.length() > 50) {
            throw new IllegalArgumentException("El nombre de la ciudad no permite mas de 50 caracteres");
        }
    }

    public static Ciudad of(String ciudad) {
        return new Ciudad(ciudad);
    }

    @Override
    public String value() {
        return ciudad;
    }
}
