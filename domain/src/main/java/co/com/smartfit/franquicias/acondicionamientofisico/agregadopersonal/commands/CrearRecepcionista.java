package co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.commands;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.values.HorarioDeTrabajo;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.values.PersonalId;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.values.RecepcionistaId;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.DocumentoIdentidad;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Email;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Nombre;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Telefono;
import co.com.sofka.domain.generic.Command;

public class CrearRecepcionista extends Command {
    private final PersonalId personalId;
    private final RecepcionistaId recepcionistaId;
    private final Nombre nombreRecepcionista;
    private final DocumentoIdentidad documentoRecepcionista;
    private final Telefono telefonoRecepcionista;
    private final Email emailRecepcionista;
    private final HorarioDeTrabajo horarioDeTrabajo;

    public CrearRecepcionista(PersonalId personalId, RecepcionistaId recepcionistaId,
                              Nombre nombreRecepcionista,
                              DocumentoIdentidad documentoRecepcionista,
                              Telefono telefonoRecepcionista,
                              Email emailRecepcionista,
                              HorarioDeTrabajo horarioDeTrabajo) {
        this.personalId = personalId;
        this.recepcionistaId = recepcionistaId;
        this.nombreRecepcionista = nombreRecepcionista;
        this.documentoRecepcionista = documentoRecepcionista;
        this.telefonoRecepcionista = telefonoRecepcionista;
        this.emailRecepcionista = emailRecepcionista;
        this.horarioDeTrabajo = horarioDeTrabajo;
    }

    public RecepcionistaId getRecepcionistaId() {
        return recepcionistaId;
    }

    public PersonalId getPersonalId() {
        return personalId;
    }

    public Nombre getNombreRecepcionista() {
        return nombreRecepcionista;
    }

    public DocumentoIdentidad getDocumentoRecepcionista() {
        return documentoRecepcionista;
    }

    public Telefono getTelefonoRecepcionista() {
        return telefonoRecepcionista;
    }

    public Email getEmailRecepcionista() {
        return emailRecepcionista;
    }

    public HorarioDeTrabajo getHorarioDeTrabajo() {
        return horarioDeTrabajo;
    }
}
