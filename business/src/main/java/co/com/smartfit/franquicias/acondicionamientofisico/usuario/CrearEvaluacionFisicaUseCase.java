package co.com.smartfit.franquicias.acondicionamientofisico.usuario;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.Usuario;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.commands.CrearEvaluacionFisica;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearEvaluacionFisicaUseCase extends UseCase<RequestCommand<CrearEvaluacionFisica>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearEvaluacionFisica> crearEvaluacionFisicaRequestCommand) {
        var command = crearEvaluacionFisicaRequestCommand.getCommand();

        var usuario = Usuario.from(command.getUsuarioId(), repository().getEventsBy(command.getUsuarioId().value()));

        usuario.crearEvaluacionFisica(command.getPeso(),
                command.getAltura());

        emit().onResponse(new ResponseEvents(usuario.getUncommittedChanges()));
    }
}
