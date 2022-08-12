package co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Marca implements ValueObject<String> {
    private final String marca;

    public Marca(String marca) {

        this.marca = Objects.requireNonNull(marca);

        if (this.marca.isBlank()) {
            throw new IllegalArgumentException("La marca de la máquina no puede estar en blanco");
        }

        if (this.marca.length() > 50) {
            throw new IllegalArgumentException("La marca de la máquina no permite mas de 50 caracteres");
        }
    }

    public static Marca of(String marca) {
        return new Marca(marca);
    }

    @Override
    public String value() {
        return marca;
    }
}
