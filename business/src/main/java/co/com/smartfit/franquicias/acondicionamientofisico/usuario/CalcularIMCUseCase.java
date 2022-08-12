package co.com.smartfit.franquicias.acondicionamientofisico.usuario;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.Usuario;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.commands.CalcularIMC;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CalcularIMCUseCase extends UseCase<RequestCommand<CalcularIMC>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CalcularIMC> calcularIMCRequestCommand) {
        var command = calcularIMCRequestCommand.getCommand();

        var usuario = Usuario.from(command.getUsuarioId(), repository().getEventsBy(command.getUsuarioId().value()));

        usuario.calcularIMC(command.getEvaluacionFisicaId(),
                command.getPeso(),
                command.getAltura());

        emit().onResponse(new ResponseEvents(usuario.getUncommittedChanges()));
    }
}
