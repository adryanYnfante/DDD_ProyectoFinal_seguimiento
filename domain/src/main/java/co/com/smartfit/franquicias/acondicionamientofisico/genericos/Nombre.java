package co.com.smartfit.franquicias.acondicionamientofisico.genericos;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Nombre implements ValueObject<String> {
    private final String nombre;

    public Nombre(String nombre) {

        this.nombre = Objects.requireNonNull(nombre);

        if (this.nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar en blanco");
        }

        if (this.nombre.length() > 100) {
            throw new IllegalArgumentException("El nombre no permite más de 100 carácteres");
        }
    }

    public static Nombre of(String nombre) {
        return new Nombre(nombre);
    }

    @Override
    public String value() {
        return nombre;
    }
}
