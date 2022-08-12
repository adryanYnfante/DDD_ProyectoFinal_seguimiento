package co.com.smartfit.franquicias.acondicionamientofisico.sede;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.Sede;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.commands.ReemplazarTorniquete;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ReemplazarTorniqueteUseCase extends UseCase<RequestCommand<ReemplazarTorniquete>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ReemplazarTorniquete> reemplazarTorniqueteRequestCommand) {
        var command = reemplazarTorniqueteRequestCommand.getCommand();

        var sede = Sede.from(command.getSedeId(), repository().getEventsBy(command.getSedeId().value()));

        sede.reemplazarTorniquete(command.getLectorHuella(),
                command.getSerial());

        emit().onResponse(new ResponseEvents(sede.getUncommittedChanges()));
    }
}
