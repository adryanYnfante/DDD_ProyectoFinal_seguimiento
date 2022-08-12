package co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.events;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values.ClaseId;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values.Duracion;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values.Rutina;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Nombre;
import co.com.sofka.domain.generic.DomainEvent;

public class ClaseCreada extends DomainEvent {

    protected final Nombre nombreClase;
    protected final Rutina rutina;
    protected final Duracion duracion;

    public ClaseCreada(ClaseId claseId,
                       Nombre nombreClase,
                       Rutina rutina,
                       Duracion duracion) {
        super("co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.ClaseCreada");
        this.nombreClase = Nombre.of(nombreClase.value());
        this.rutina = rutina;
        this.duracion = Duracion.of(duracion.value());
    }

    public Nombre getNombreClase() {
        return nombreClase;
    }

    public Rutina getRutina() {
        return rutina;
    }

    public Duracion getDuracion() {
        return duracion;
    }
}
