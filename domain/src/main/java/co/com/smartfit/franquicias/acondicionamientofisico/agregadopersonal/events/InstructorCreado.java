package co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.events;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.values.Cantidad;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.values.InstructorId;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.DocumentoIdentidad;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Email;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Nombre;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Telefono;
import co.com.sofka.domain.generic.DomainEvent;

public class InstructorCreado extends DomainEvent {
    private final InstructorId instructorId;
    private final Nombre nombreInstructor;
    private final DocumentoIdentidad documentoInstructor;
    private final Telefono telefonoInstructor;
    private final Email emailInstructor;
    //    private final Cargo cargo;
    private final Cantidad cantidadUsuarios;

    public InstructorCreado(InstructorId instructorId,
                            Nombre nombreInstructor,
                            DocumentoIdentidad documentoInstructor,
                            Telefono telefonoInstructor,
                            Email emailInstructor,
//                            Cargo cargo,
                            Cantidad cantidadUsuarios) {
        super("co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.InstructorCreado");

        this.instructorId = instructorId;
        this.nombreInstructor = nombreInstructor;
        this.documentoInstructor = documentoInstructor;
        this.telefonoInstructor = telefonoInstructor;
        this.emailInstructor = emailInstructor;
//        this.cargo = cargo;
        this.cantidadUsuarios = cantidadUsuarios;
    }

//    public Cargo getCargo() {
//        return cargo;
//    }

    public InstructorId getInstructorId() {
        return instructorId;
    }

    public Nombre getNombreInstructor() {
        return nombreInstructor;
    }

    public DocumentoIdentidad getDocumentoInstructor() {
        return documentoInstructor;
    }

    public Telefono getTelefonoInstructor() {
        return telefonoInstructor;
    }

    public Email getEmailInstructor() {
        return emailInstructor;
    }

    public Cantidad getCantidadUsuarios() {
        return cantidadUsuarios;
    }
}
