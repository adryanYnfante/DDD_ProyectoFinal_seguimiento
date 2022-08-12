package co.com.smartfit.franquicias.acondicionamientofisico.personal;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.Personal;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.commands.CrearAdministrador;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearPersonalAdministradorUseCase extends UseCase<RequestCommand<CrearAdministrador>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearAdministrador> crearAdministradorRequestCommand) {
        var command = crearAdministradorRequestCommand.getCommand();

        var administrador = new Personal(command.getPersonalId(),
                command.getAdministradorId(),
                command.getNombreAdministrador(),
                command.getDocumentoAdministrador(),
                command.getTelefonoAdministrador(),
                command.getEmailAdministrador(),
                command.getPromocion()
        );
        emit().onResponse(new ResponseEvents(administrador.getUncommittedChanges()));
    }


}
