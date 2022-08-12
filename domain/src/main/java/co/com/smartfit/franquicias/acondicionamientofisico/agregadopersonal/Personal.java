package co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.events.*;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.values.*;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.DocumentoIdentidad;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Email;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Nombre;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Telefono;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Map;

public class Personal extends AggregateEvent<PersonalId> {

    protected PersonalId personalId;
    protected RecepcionistaId recepcionistaId;
    protected MedicoId medicoId;
    protected InstructorId instructorId;
    protected AdministradorId administradorId;
    protected Map<MedicoId, Medico> medicos;
    protected Cargo cargo;
    protected Recepcionista recepcionista;
    protected Medico medico;
    protected Instructor instructor;
    protected Administrador administrador;

    public Personal(PersonalId personalId,
                    RecepcionistaId recepcionistaId,
                    Nombre nombre,
                    DocumentoIdentidad documentoRecepcionista,
                    Telefono telefonoRecepcionista,
                    Email emailRecepcionista,
                    HorarioDeTrabajo horarioDeTrabajo) {
        super(personalId);
        appendChange(new RecepcionistaCreado(recepcionistaId,
                nombre, documentoRecepcionista, telefonoRecepcionista,
                emailRecepcionista, horarioDeTrabajo)).apply();
        subscribe(new PersonalEventChange(this));
    }

    public Personal(PersonalId personalId,
                    MedicoId medicoId,
                    Nombre nombreMedico,
                    DocumentoIdentidad documentoMedico,
                    Telefono telefonoMedico,
                    Email emailMedico,
                    DiasALaborar diasALaborar,
                    Cargo cargo) {
        super(personalId);
        appendChange(new MedicoCreado(medicoId, nombreMedico,
                documentoMedico, telefonoMedico, emailMedico, diasALaborar, cargo)).apply();
        subscribe(new PersonalEventChange(this));
    }

    public Personal(PersonalId personalId,
                    InstructorId instructorId,
                    Nombre nombreInstructor,
                    DocumentoIdentidad documentoInstructor,
                    Telefono telefonoInstructor,
                    Email emailInstructor,
                    Cantidad cantidadUsuarios) {
        super(personalId);
        appendChange(new InstructorCreado(instructorId, nombreInstructor, documentoInstructor,
                telefonoInstructor, emailInstructor, cantidadUsuarios)).apply();
        subscribe(new PersonalEventChange(this));
    }

    public Personal(PersonalId personalId,
                    AdministradorId administradorId,
                    Nombre nombreAdministrador,
                    DocumentoIdentidad documentoAdministrador,
                    Telefono telefonoAdministrador,
                    Email emailAdministrador,
                    Promocion promocion) {
        super(personalId);
        appendChange(new AdministradorCreado(administradorId, nombreAdministrador,
                documentoAdministrador, telefonoAdministrador, emailAdministrador, promocion)).apply();
        subscribe(new PersonalEventChange(this));
    }

    private Personal(PersonalId personalId) {
        super(personalId);
        subscribe(new PersonalEventChange(this));
    }

    public static Personal from(PersonalId personalId, List<DomainEvent> events) {
        var personal = new Personal(personalId);
        events.forEach(personal::applyEvent);
        return personal;
    }

}
