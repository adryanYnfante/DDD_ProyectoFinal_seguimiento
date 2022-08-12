package co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Promocion implements ValueObject<String> {

    private final String promocion;

    public Promocion(String promocion) {
        this.promocion = Objects.requireNonNull(promocion);

        if (this.promocion.isBlank() || this.promocion.isEmpty()) {
            throw new IllegalArgumentException("El texto de la promoción no puede estar vacio o en blanco");
        }
    }

    public static Promocion of(String promocion) {
        return new Promocion(promocion);
    }

    @Override
    public String value() {
        return promocion;
    }
}
