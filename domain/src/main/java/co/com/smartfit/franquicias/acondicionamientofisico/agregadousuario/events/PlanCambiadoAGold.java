package co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.events;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values.CuentaId;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values.Mensualidad;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values.Plan;
import co.com.sofka.domain.generic.DomainEvent;

public class PlanCambiadoAGold extends DomainEvent {
    private final CuentaId cuentaId;

    private final Mensualidad mensualidad;
    private final Plan plan;

    public PlanCambiadoAGold(CuentaId cuentaId, Mensualidad mensualidad, Plan plan) {
        super("co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.PlanCambiadoAGold");
        this.cuentaId = cuentaId;
        this.mensualidad = mensualidad;
        this.plan = plan;
    }

    public Plan getPlan() {
        return plan;
    }

    public Mensualidad getMensualidad() {
        return mensualidad;
    }

    public CuentaId getCuentaId() {
        return cuentaId;
    }

}
