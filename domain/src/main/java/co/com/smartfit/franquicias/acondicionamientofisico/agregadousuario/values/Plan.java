package co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Plan implements ValueObject<Plan.Tipo> {
    private Tipo plan;

    public Plan(Tipo plan) {
        this.plan = Objects.requireNonNull(plan);

        if (String.valueOf(this.plan).isBlank()) {
            throw new IllegalArgumentException("El peso no debe estar en blanco");
        }
    }

    public static Plan of(Tipo plan) {
        return new Plan(plan);
    }

    @Override
    public Tipo value() {
        return plan;
    }

    public enum Tipo {
        PLAN_BÁSICO, PLAN_GOLD, PLAN_PREMIUN;
    }
}
