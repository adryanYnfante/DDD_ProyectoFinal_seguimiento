package co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.events;

import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Estado;
import co.com.sofka.domain.generic.DomainEvent;

public class EstadoActualizado extends DomainEvent {

    private final Estado estado;
    public EstadoActualizado(Estado estado) {
        super("co.com.smartfit.franquicias.acondicionamientofisico.EstadoActualizado");
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }
}
