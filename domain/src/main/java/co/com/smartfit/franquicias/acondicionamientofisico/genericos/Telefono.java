package co.com.smartfit.franquicias.acondicionamientofisico.genericos;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Telefono implements ValueObject<String> {

    private final String telefono;

    public Telefono(String telefono) {
        this.telefono = Objects.requireNonNull(telefono);

        if (this.telefono.isBlank()) {
            throw new IllegalArgumentException("El telefono no puede estar vacio");
        }

        if (this.telefono.length() > 10) {
            throw new IllegalArgumentException("El telefono no permite mas de 10 caracteres");
        }

        if (this.telefono.length() <= 0) {
            throw new IllegalArgumentException("El telefono no puede ser cero o negativo");
        }

    }

    public static Telefono of(String telefono) {
        return new Telefono(telefono);
    }

    @Override
    public String value() {
        return telefono;
    }
}
