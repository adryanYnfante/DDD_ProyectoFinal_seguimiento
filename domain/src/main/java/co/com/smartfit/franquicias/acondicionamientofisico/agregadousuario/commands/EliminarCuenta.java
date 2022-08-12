package co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.commands;

import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Estado;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values.UsuarioId;
import co.com.sofka.domain.generic.Command;

public class EliminarCuenta extends Command {

    private final UsuarioId usuarioId;
    private final Estado estado;

    public EliminarCuenta(UsuarioId usuarioId, Estado estado) {
        this.usuarioId = usuarioId;
        this.estado = estado;
    }

    public UsuarioId getUsuarioId() {
        return usuarioId;
    }

    public Estado getEstado() {
        return estado;
    }
}
