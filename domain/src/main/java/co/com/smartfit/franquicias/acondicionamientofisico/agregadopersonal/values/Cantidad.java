package co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Cantidad implements ValueObject<String> {

    private final String cantidad;

    public Cantidad(String cantidad) {
        this.cantidad = Objects.requireNonNull(cantidad);

        if (this.cantidad.isBlank()) {
            throw new IllegalArgumentException("La cantidad de usuarios no puede estar vacio");
        }

        if (this.cantidad.length() <= 0) {
            throw new IllegalArgumentException("La cantidad de usuarios no puede ser cero o negativo");
        }

    }

    public static Cantidad of(String cantidad) {
        return new Cantidad(cantidad);
    }

    @Override
    public String value() {
        return cantidad;
    }
}

