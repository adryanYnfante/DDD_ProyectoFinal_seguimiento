package co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.commands;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.values.SedeId;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Telefono;
import co.com.sofka.domain.generic.Command;

public class CambiarTelefonoSede extends Command {
    private final SedeId sedeId;
    private final Telefono telefono;

    public CambiarTelefonoSede(SedeId sedeId, Telefono telefono) {
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
