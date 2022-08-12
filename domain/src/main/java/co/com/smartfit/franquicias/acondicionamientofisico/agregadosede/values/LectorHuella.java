package co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class LectorHuella implements ValueObject<String> {
    private final String huella;

    public LectorHuella(String huella) {

        this.huella = Objects.requireNonNull(huella);

        if (this.huella.equals("") || this.huella.equals(" ")) {
            throw new IllegalArgumentException("La huella no puede estar en blanco o vacía");
        }
    }

    public static LectorHuella of(String huella) {
        return new LectorHuella(huella);
    }

    @Override
    public String value() {
        return huella;
    }
}
