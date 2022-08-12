package co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class IMC implements ValueObject<Double> {

    private final Double imc;

    public IMC(Double imc) {
        this.imc = Objects.requireNonNull(imc);

        if (this.imc <= 0) {
            throw new IllegalArgumentException("El IMC no debe ser cero o un valor negativo");
        }

        if (String.valueOf(this.imc).isBlank()) {
            throw new IllegalArgumentException("El IMC no debe estar en blanco");
        }
    }

    public static IMC of(Double imc) {
        return new IMC(imc);
    }

    @Override
    public Double value() {
        return imc;
    }
}