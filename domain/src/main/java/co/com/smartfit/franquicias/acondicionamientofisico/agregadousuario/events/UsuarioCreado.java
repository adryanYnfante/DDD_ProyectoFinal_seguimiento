package co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.events;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values.UsuarioId;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Email;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Nombre;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Telefono;
import co.com.sofka.domain.generic.DomainEvent;

public class UsuarioCreado extends DomainEvent {

    private final Nombre nombre;
    private final Telefono telefono;
    private final Email email;

    public UsuarioCreado(UsuarioId usuarioId, Nombre nombre, Telefono telefono, Email email) {
        super("co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.UsuarioCreado");
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    public Nombre getNombreCompleto() {
        return nombre;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public Email getEmail() {
        return email;
    }
}
