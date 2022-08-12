package co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.values.Cantidad;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.values.InstructorId;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.DocumentoIdentidad;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Email;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Nombre;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Telefono;
import co.com.sofka.domain.generic.Entity;

public class Instructor extends Entity<InstructorId> {
    protected Nombre nombreInstructor;
    protected DocumentoIdentidad documentoInstructor;
    protected Telefono telefonoInstructor;
    protected Email emailInstructor;

    protected Cantidad cantidadUsuarios;

    public Instructor(InstructorId instructorId,
                      Nombre nombreInstructor,
                      DocumentoIdentidad documentoInstructor,
                      Telefono telefonoInstructor,
                      Email emailInstructor,
                      Cantidad cantidadUsuarios) {
        super(instructorId);
        this.nombreInstructor = nombreInstructor;
        this.documentoInstructor = documentoInstructor;
        this.telefonoInstructor = telefonoInstructor;
        this.emailInstructor = emailInstructor;

    }
}
