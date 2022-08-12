package co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.events;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.values.SedeId;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Telefono;
import co.com.sofka.domain.generic.DomainEvent;

public class TelefonoSedeCambiado extends DomainEvent {
    private final SedeId sedeId;
    private final Telefono telefono;

    public TelefonoSedeCambiado(SedeId sedeId, Telefono telefono) {
        super("co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.TelefonoSedeCambiado");
        this.sedeId = sedeId;
        this.telefono = telefono;
    }

    public SedeId getSedeId() {
        return sedeId;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
