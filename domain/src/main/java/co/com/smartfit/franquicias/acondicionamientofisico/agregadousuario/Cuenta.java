package co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values.CuentaId;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values.Mensualidad;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values.Plan;
import co.com.sofka.domain.generic.Entity;

public class Cuenta extends Entity<CuentaId> {
    protected Mensualidad mensualidad;
    protected Plan plan;

    public Cuenta(CuentaId cuentaId, Mensualidad mensualidad, Plan plan) {
        super(cuentaId);
        this.mensualidad = mensualidad;
        this.plan = plan;
    }
    public void cambiarAPlanGold(CuentaId cuentaId, Plan plan) {

        this.plan = plan;
    }
    public void cambiarAPlanPremiun(CuentaId cuentaId, Plan plan) {
        this.plan = plan;
    }

}
