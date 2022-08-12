package co.com.smartfit.franquicias.acondicionamientofisico.usuario;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.Usuario;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.commands.CrearClase;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearClaseUseCase extends UseCase<RequestCommand<CrearClase>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearClase> crearClaseRequestCommand) {
        var command = crearClaseRequestCommand.getCommand();

        var usuario = Usuario.from(command.getUsuarioId(), repository().getEventsBy(command.getUsuarioId().value()));

        usuario.crearClase(command.getNombreClase(),
                command.getRutina(),
                command.getDuracion());

        emit().onResponse(new ResponseEvents(usuario.getUncommittedChanges()));
    }
}
