package co.com.smartfit.franquicias.acondicionamientofisico.usuario;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.Usuario;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.commands.EliminarCuenta;
import co.com.smartfit.franquicias.acondicionamientofisico.services.ConsultarEstadoUsuario;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class EliminarCuentaUseCase extends UseCase<RequestCommand<EliminarCuenta>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<EliminarCuenta> eliminarUsuarioRequestCommand) {
        var command = eliminarUsuarioRequestCommand.getCommand();
        var estadoService = getService(ConsultarEstadoUsuario.class).orElseThrow();
        var usuario = Usuario.from(command.getUsuarioId(), repository().getEventsBy(command
                .getUsuarioId().value()));

        usuario.eliminarCuenta(estadoService.consultarPorUsuarioId(command.getUsuarioId()));

        emit().onResponse(new ResponseEvents(usuario.getUncommittedChanges()));
    }
}
