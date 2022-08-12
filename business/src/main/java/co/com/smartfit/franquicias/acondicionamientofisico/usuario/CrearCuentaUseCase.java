package co.com.smartfit.franquicias.acondicionamientofisico.usuario;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.Usuario;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.commands.CrearCuenta;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearCuentaUseCase extends UseCase<RequestCommand<CrearCuenta>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearCuenta> crearCuentaRequestCommand) {
        var command = crearCuentaRequestCommand.getCommand();

        var usuario = Usuario.from(command.getUsuarioId(), repository().getEventsBy(command.getUsuarioId().value()));

        usuario.crearCuenta(command.getMensualidad(), command.getPlan());

        emit().onResponse(new ResponseEvents(usuario.getUncommittedChanges()));
    }
}
