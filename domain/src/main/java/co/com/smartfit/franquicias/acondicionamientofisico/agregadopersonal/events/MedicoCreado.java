package co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.events;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.values.Cargo;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.values.DiasALaborar;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.values.MedicoId;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.DocumentoIdentidad;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Email;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Nombre;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Telefono;
import co.com.sofka.domain.generic.DomainEvent;

public class MedicoCreado extends DomainEvent {
    private final MedicoId medicoId;
    private final Nombre nombreMedico;
    private final DocumentoIdentidad documentoMedico;
    private final Telefono telefonoMedico;
    private final Email emailMedico;
    private final Cargo cargo;
    private final DiasALaborar diasALaborar;

    public MedicoCreado(MedicoId medicoId,
                        Nombre nombreMedico,
                        DocumentoIdentidad documentoMedico,
                        Telefono telefonoMedico,
                        Email emailMedico,
//                        Cargo cargo,
                        DiasALaborar diasALaborar, Cargo cargo) {
        super("co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.MedicoCreado");

        this.medicoId = medicoId;
        this.nombreMedico = nombreMedico;
        this.documentoMedico = documentoMedico;
        this.telefonoMedico = telefonoMedico;
        this.emailMedico = emailMedico;
//        this.cargo = cargo;
        this.diasALaborar = diasALaborar;
        this.cargo = cargo;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public MedicoId getMedicoId() {
        return medicoId;
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
}
