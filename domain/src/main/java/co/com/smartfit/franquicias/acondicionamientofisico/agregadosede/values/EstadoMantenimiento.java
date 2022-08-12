package co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class EstadoMantenimiento implements ValueObject<EstadoMantenimiento.Tipo> {

    private EstadoMantenimiento.Tipo tipoMantenimiento;

    public EstadoMantenimiento(EstadoMantenimiento.Tipo tipoMantenimiento) {
        this.tipoMantenimiento = Objects.requireNonNull(tipoMantenimiento);

        if (String.valueOf(this.tipoMantenimiento).isBlank()) {
            throw new IllegalArgumentException("El tipo de mantenimiento no debe estar en blanco");
        }
    }

    public static EstadoMantenimiento of(EstadoMantenimiento.Tipo tipoMantenimiento) {

        return new EstadoMantenimiento(tipoMantenimiento);
    }

    @Override
    public EstadoMantenimiento.Tipo value() {
        return tipoMantenimiento;
    }

    public enum Tipo {
        EN_BUEN_ESTADO, EN_ESPERA, EN_MANTENIMIENTO, MALA;
    }
}
