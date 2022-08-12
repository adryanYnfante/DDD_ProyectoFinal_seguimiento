package co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.commands;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.values.Ciudad;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.values.Direccion;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.values.SedeId;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Nombre;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Telefono;
import co.com.sofka.domain.generic.Command;

public class CrearSede extends Command {

    private final SedeId sedeId;
    private final Nombre nombreSede;
    private final Ciudad ciudad;
    private final Direccion direccion;
    private final Telefono telefono;

    public CrearSede(SedeId sedeId, Nombre nombreSede,
                     Ciudad ciudad, Direccion direccion, Telefono telefono) {
        this.sedeId = sedeId;
        this.nombreSede = nombreSede;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public SedeId getSedeId() {
        return sedeId;
    }

    public Nombre getNombreSede() {
        return nombreSede;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
