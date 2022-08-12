package co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.commands;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.values.Cargo;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.values.DiasALaborar;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.values.MedicoId;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.values.PersonalId;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.DocumentoIdentidad;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Email;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Nombre;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Telefono;
import co.com.sofka.domain.generic.Command;

public class CrearMedico extends Command {
    private final PersonalId personalId;

    private final MedicoId medicoId;
    private final Nombre nombreMedico;
    private final DocumentoIdentidad documentoMedico;
    private final Telefono telefonoMedico;
    private final Email emailMedico;
    private final DiasALaborar diasALaborar;

    private final Cargo cargo;

    public CrearMedico(PersonalId personalId, MedicoId medicoId, Nombre nombreMedico,
                       DocumentoIdentidad documentoMedico,
                       Telefono telefonoMedico, Email emailMedico,
                       DiasALaborar diasALaborar, Cargo cargo) {
        this.personalId = personalId;
        this.medicoId = medicoId;
        this.nombreMedico = nombreMedico;
        this.documentoMedico = documentoMedico;
        this.telefonoMedico = telefonoMedico;
        this.emailMedico = emailMedico;
        this.diasALaborar = diasALaborar;
        this.cargo = cargo;
    }

    public MedicoId getMedicoId() {
        return medicoId;
    }

    public PersonalId getPersonalId() {
        return personalId;
    }

    public Nombre getNombreMedico() {
        return nombreMedico;
    }

    public DocumentoIdentidad getDocumentoMedico() {
        return documentoMedico;
    }

    public Telefono getTelefonoMedico() {
        return telefonoMedico;
    }

    public Email getEmailMedico() {
        return emailMedico;
    }

    public DiasALaborar getDiasALaborar() {
        return diasALaborar;
    }

    public Cargo getCargo() {
        return cargo;
    }
}
