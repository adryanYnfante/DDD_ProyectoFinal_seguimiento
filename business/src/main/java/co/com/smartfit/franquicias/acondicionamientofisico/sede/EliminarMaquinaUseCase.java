package co.com.smartfit.franquicias.acondicionamientofisico.sede;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.Sede;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.commands.EliminarMaquina;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class EliminarMaquinaUseCase extends UseCase<RequestCommand<EliminarMaquina>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<EliminarMaquina> eliminarMaquinaRequestCommand) {
        var command = eliminarMaquinaRequestCommand.getCommand();

        var sede = Sede.from(command.getSedeId(), repository().getEventsBy(command.getSedeId().value()));

        sede.eliminarMaquina(command.getMaquinaId());

        emit().onResponse(new ResponseEvents(sede.getUncommittedChanges()));
    }
}
