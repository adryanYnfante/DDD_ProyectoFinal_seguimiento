package co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.events.*;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Estado;
import co.com.sofka.domain.generic.EventChange;

public class PersonalEventChange extends EventChange {
    public PersonalEventChange(Personal personal) {

        apply((MedicoCreado event) -> {
            personal.medico = new Medico(event.getMedicoId(), event.getNombreMedico(),
                    event.getDocumentoMedico(), event.getTelefonoMedico(),
                   event.getEmailMedico(), event.getDiasALaborar(),
                    new Estado(Estado.Tipo.LABORANDO));
        });

        apply((RecepcionistaCreado event) -> {
            personal.recepcionista = new Recepcionista(event.getRecepcionistaId(),
                    event.getNombreRecepcionista(), event.getDocumentoRecepcionista(),
                    event.getTelefonoRecepcionista(), event.getEmailRecepcionista(),
                    event.getHorarioDeTrabajo());
        });

        apply((InstructorCreado event) -> {
            personal.instructor = new Instructor(event.getInstructorId(), event.getNombreInstructor(),
                    event.getDocumentoInstructor(), event.getTelefonoInstructor(),
                    event.getEmailInstructor(), event.getCantidadUsuarios());
        });

        apply((AdministradorCreado event) -> {
            personal.administrador = new Administrador(event.getAdministradorId(),
                    event.getNombreAdministrador(), event.getDocumentoAdministrador(),
                    event.getTelefonoAdministrador(), event.getEmailAdministrador(),
                    event.getPromocion());
        });
    }
}
