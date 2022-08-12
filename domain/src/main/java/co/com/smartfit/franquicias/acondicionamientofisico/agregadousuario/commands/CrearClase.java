package co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.commands;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values.ClaseId;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values.Duracion;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values.Rutina;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values.UsuarioId;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Nombre;
import co.com.sofka.domain.generic.Command;

public class CrearClase extends Command {
    private final UsuarioId usuarioId;
    private final ClaseId claseId;
    private final Nombre nombreClase;
    private final Rutina rutina;
    private final Duracion duracion;

    public CrearClase(UsuarioId usuarioId, ClaseId claseId,
                      Nombre nombreClase, Rutina rutina,
                      Duracion duracion) {
        this.usuarioId = usuarioId;
        this.claseId = claseId;
        this.nombreClase = nombreClase;
        this.rutina = rutina;
        this.duracion = duracion;
    }

    public UsuarioId getUsuarioId() {
        return usuarioId;
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
