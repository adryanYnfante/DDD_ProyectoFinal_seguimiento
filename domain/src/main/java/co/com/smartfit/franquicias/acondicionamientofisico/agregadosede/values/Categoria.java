package co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Categoria implements ValueObject<String> {
    private final String categoria;

    public Categoria(String categoria) {

        this.categoria = Objects.requireNonNull(categoria);

        if (this.categoria.isBlank()) {
            throw new IllegalArgumentException("El nombre de la categoria no puede estar vacio");
        }

        if (this.categoria.length() > 50) {
            throw new IllegalArgumentException("El nombre de la categoria no permite mas de 50 caracteres");
        }
    }

    public static Categoria of(String categoria) {
        return new Categoria(categoria);
    }

    @Override
    public String value() {
        return categoria;
    }
}
