package co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.events;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values.CuentaId;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values.Mensualidad;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values.Plan;
import co.com.sofka.domain.generic.DomainEvent;

public class PlanCambiadoAPremiun extends DomainEvent {

    private final CuentaId cuentaId;
    private final Mensualidad mensualidad;
    private final Plan plan;

    public PlanCambiadoAPremiun(CuentaId cuentaId, Mensualidad mensualidad, Plan plan) {
        super("co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.PlanCambiadoAPremiun");
        this.cuentaId = cuentaId;
        this.mensualidad = mensualidad;
        this.plan = plan;
    }

    public Mensualidad getMensualidad() {
        return mensualidad;
    }

    public Plan getPlan() {
        return plan;
    }

    public CuentaId getCuentaId() {
        return cuentaId;
    }
}
