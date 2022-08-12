package co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.events;

import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Estado;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values.UsuarioId;
import co.com.sofka.domain.generic.DomainEvent;

public class EstadoUsuarioAsignado extends DomainEvent {
    private final UsuarioId usuarioId;

    public EstadoUsuarioAsignado(UsuarioId usuarioId, Estado estado) {
        super("co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario");
        this.usuarioId = usuarioId;
    }

    public UsuarioId getUsuarioId() {
        return usuarioId;
    }
}
