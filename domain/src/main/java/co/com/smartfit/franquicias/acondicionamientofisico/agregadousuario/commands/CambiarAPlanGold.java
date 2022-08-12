package co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.commands;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values.CuentaId;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values.Mensualidad;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values.Plan;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values.UsuarioId;
import co.com.sofka.domain.generic.Command;

public class CambiarAPlanGold extends Command {
    private final UsuarioId usuarioId;
    private final CuentaId cuentaId;

    private final Mensualidad mensualidad;
    private final Plan plan;

    public CambiarAPlanGold(UsuarioId usuarioId, CuentaId cuentaId, Mensualidad mensualidad, Plan plan) {
        this.usuarioId = usuarioId;
        this.cuentaId = cuentaId;
        this.mensualidad = mensualidad;
        this.plan = plan;
    }

    public UsuarioId getUsuarioId() {
        return usuarioId;
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
