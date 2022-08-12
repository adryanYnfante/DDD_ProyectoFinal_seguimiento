package co.com.smartfit.franquicias.acondicionamientofisico.personal;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.Personal;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.commands.CrearInstructor;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearPersonalInstructorUseCase extends UseCase<RequestCommand<CrearInstructor>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearInstructor> crearInstructorRequestCommand) {
        var command = crearInstructorRequestCommand.getCommand();

        var instructor = new Personal(command.getPersonalId(),
                command.getInstructorId(),
                command.getNombreInstructor(),
                command.getDocumentoInstructor(),
                command.getTelefonoInstructor(),
                command.getEmailInstructor(),
                command.getCantidadUsuarios()
        );
        emit().onResponse(new ResponseEvents(instructor.getUncommittedChanges()));
    }
}
