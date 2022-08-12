package co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.events;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values.ClaseId;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Nombre;
import co.com.sofka.domain.generic.DomainEvent;

public class NombreDeLaClaseCambiado extends DomainEvent {
    private final ClaseId claseId;
    private final Nombre nombreClase;

    public NombreDeLaClaseCambiado(ClaseId claseId, Nombre nombreClase) {
        super("co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.NombreDeLaClaseCambiado");
        this.claseId = claseId;
        this.nombreClase = nombreClase;
    }

    public ClaseId getClaseId() {
        return claseId;
    }

    public Nombre getNombreClase() {
        return nombreClase;
    }
}
