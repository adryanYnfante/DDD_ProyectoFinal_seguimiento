package co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Direccion implements ValueObject<String> {
    private final String direccion;

    public Direccion(String direccion) {

        this.direccion = Objects.requireNonNull(direccion);

        if (this.direccion.isBlank()) {
            throw new IllegalArgumentException("La dirección de la sede no puede estar en blanco");
        }

        if (this.direccion.length() > 50) {
            throw new IllegalArgumentException("La dirección de la sede no permite mas de 50 caracteres");
        }
    }

    public static Direccion of(String direccion) {
        return new Direccion(direccion);
    }

    @Override
    public String value() {
        return direccion;
    }
}
