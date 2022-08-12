package co.com.smartfit.franquicias.acondicionamientofisico.usuario;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.Usuario;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.commands.CambiarNombreDeLaClase;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CambiarNombreDeLaClaseUseCase extends UseCase<RequestCommand<CambiarNombreDeLaClase>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarNombreDeLaClase> cambiarNombreDeLaClaseRequestCommand) {
        var command = cambiarNombreDeLaClaseRequestCommand.getCommand();

        var usuario = Usuario.from(command.getUsuarioId(),
                repository().getEventsBy(command.getUsuarioId().value()));

        usuario.cambiarNombreDeLaClase(command.getClaseId(),
                command.getNombreClase());

        emit().onResponse(new ResponseEvents(usuario.getUncommittedChanges()));
    }
}
