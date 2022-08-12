package co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.values.HorarioDeTrabajo;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.values.RecepcionistaId;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.DocumentoIdentidad;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Email;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Nombre;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Telefono;
import co.com.sofka.domain.generic.Entity;

public class Recepcionista extends Entity<RecepcionistaId> {

    protected Nombre nombreRecepcionista;
    protected DocumentoIdentidad documentoRecepcionista;
    protected Telefono telefonoRecepcionista;
    protected Email emailRecepcionista;

    protected HorarioDeTrabajo horarioDeTrabajo;

    public Recepcionista(RecepcionistaId recepcionistaId,
                         Nombre nombreRecepcionista,
                         DocumentoIdentidad documentoRecepcionista,
                         Telefono telefonoRecepcionista,
                         Email emailRecepcionista,
                         HorarioDeTrabajo horarioDeTrabajo) {
        super(recepcionistaId);
        this.nombreRecepcionista = nombreRecepcionista;
        this.documentoRecepcionista = documentoRecepcionista;
        this.telefonoRecepcionista = telefonoRecepcionista;
        this.emailRecepcionista = emailRecepcionista;
        this.horarioDeTrabajo = horarioDeTrabajo;
    }
}
