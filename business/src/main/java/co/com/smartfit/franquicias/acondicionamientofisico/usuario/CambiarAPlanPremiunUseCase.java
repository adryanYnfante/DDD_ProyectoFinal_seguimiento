package co.com.smartfit.franquicias.acondicionamientofisico.usuario;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.Usuario;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.commands.CambiarAPlanPremiun;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CambiarAPlanPremiunUseCase extends UseCase<RequestCommand<CambiarAPlanPremiun>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarAPlanPremiun> cambiarAPlanPremiunRequestCommand) {
        var command = cambiarAPlanPremiunRequestCommand.getCommand();

        var usuario = Usuario.from(command.getUsuarioId(), repository().getEventsBy(command.getUsuarioId().value()));

        usuario.cambiarAPlanPremiun(command.getCuentaId(),
                command.getMensualidad(),
                command.getPlan());

        emit().onResponse(new ResponseEvents(usuario.getUncommittedChanges()));
    }
}
