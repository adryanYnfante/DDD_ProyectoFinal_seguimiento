package co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.events;

import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Estado;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values.UsuarioId;
import co.com.sofka.domain.generic.DomainEvent;

public class CuentaEliminada extends DomainEvent {
    private final Estado estado;
    private final UsuarioId usuarioId;
    public CuentaEliminada(Estado estado, UsuarioId usuarioId) {
        super("co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.CuentaEliminada");
        this.estado = estado;
        this.usuarioId = usuarioId;
    }

    public Estado getEstado() {
        return estado;
    }

    public UsuarioId getUsuarioId() {
        return usuarioId;
    }
}
