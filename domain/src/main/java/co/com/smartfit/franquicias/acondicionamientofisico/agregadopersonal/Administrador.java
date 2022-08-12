package co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.values.AdministradorId;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.values.Promocion;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.DocumentoIdentidad;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Email;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Nombre;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Telefono;
import co.com.sofka.domain.generic.Entity;

public class Administrador extends Entity<AdministradorId> {

    protected Nombre nombreAdministrador;
    protected DocumentoIdentidad documentoAdministrador;
    protected Telefono telefonoAdministrador;
    protected Email emailAdministrador;

    protected Promocion promocion;

    public Administrador(AdministradorId administradorId,
                         Nombre nombreAdministrador,
                         DocumentoIdentidad documentoAdministrador,
                         Telefono telefonoAdministrador,
                         Email emailAdministrador,
                         Promocion promocion) {
        super(administradorId);
        this.nombreAdministrador = nombreAdministrador;
        this.documentoAdministrador = documentoAdministrador;
        this.telefonoAdministrador = telefonoAdministrador;
        this.emailAdministrador = emailAdministrador;
        this.promocion = promocion;

    }

}
