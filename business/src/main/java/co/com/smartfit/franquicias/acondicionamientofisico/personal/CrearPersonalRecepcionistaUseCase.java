package co.com.smartfit.franquicias.acondicionamientofisico.personal;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.Personal;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.commands.CrearRecepcionista;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearPersonalRecepcionistaUseCase extends UseCase<RequestCommand<CrearRecepcionista>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearRecepcionista> crearRecepcionistaRequestCommand) {
        var command = crearRecepcionistaRequestCommand.getCommand();

        var recepcionista = new Personal(command.getPersonalId(),
                command.getRecepcionistaId(),
                command.getNombreRecepcionista(),
                command.getDocumentoRecepcionista(),
                command.getTelefonoRecepcionista(),
                command.getEmailRecepcionista(),
                command.getHorarioDeTrabajo()
        );
        emit().onResponse(new ResponseEvents(recepcionista.getUncommittedChanges()));
    }


}
