package co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.commands;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values.ClaseId;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values.UsuarioId;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Nombre;
import co.com.sofka.domain.generic.Command;

public class CambiarNombreDeLaClase extends Command {
    private final UsuarioId usuarioId;
    private final ClaseId claseId;
    private final Nombre nombreClase;

    public CambiarNombreDeLaClase(UsuarioId usuarioId, ClaseId claseId, Nombre nombreClase) {
        this.usuarioId = usuarioId;
        this.claseId = claseId;
        this.nombreClase = nombreClase;
    }

    public UsuarioId getUsuarioId() {
        return usuarioId;
    }
    public ClaseId getClaseId() {
        return claseId;
    }

    public Nombre getNombreClase() {
        return nombreClase;
    }
}
