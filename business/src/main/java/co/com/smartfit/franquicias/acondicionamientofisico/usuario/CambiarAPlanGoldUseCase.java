package co.com.smartfit.franquicias.acondicionamientofisico.usuario;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.Usuario;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.commands.CambiarAPlanGold;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CambiarAPlanGoldUseCase extends UseCase<RequestCommand<CambiarAPlanGold>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarAPlanGold> cambiarAPlanGoldRequestCommand) {
        var command = cambiarAPlanGoldRequestCommand.getCommand();

        var usuario = Usuario.from(command.getUsuarioId(), repository().getEventsBy(command.getUsuarioId().value()));

        usuario.cambiarAPlanGold(command.getCuentaId(),
                command.getMensualidad(),
                command.getPlan());

        emit().onResponse(new ResponseEvents(usuario.getUncommittedChanges()));
    }
}
