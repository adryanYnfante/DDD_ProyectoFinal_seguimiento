package co.com.smartfit.franquicias.acondicionamientofisico.sede;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.Sede;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.commands.CrearTorniquete;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearTorniqueteUseCase extends UseCase<RequestCommand<CrearTorniquete>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearTorniquete> crearTorniqueteRequestCommand) {
        var command = crearTorniqueteRequestCommand.getCommand();

        var sede = Sede.from(command.getSedeId(), repository().getEventsBy(command.getSedeId().value()));

        sede.crearTorniquete(command.getLectorHuella(),
                command.getSerial());
        emit().onResponse(new ResponseEvents(sede.getUncommittedChanges()));
    }

}
