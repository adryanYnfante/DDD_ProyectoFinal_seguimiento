package co.com.smartfit.franquicias.acondicionamientofisico.sede;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.Sede;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.commands.ReemplazarMaquina;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ReemplazarMaquinaUseCase extends UseCase<RequestCommand<ReemplazarMaquina>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ReemplazarMaquina> reemplazarMaquinaRequestCommand) {
        var command = reemplazarMaquinaRequestCommand.getCommand();

        var sede = Sede.from(command.getSedeId(), repository().getEventsBy(command.getSedeId().value()));

        sede.reemplazarMaquina(command.getNombreMaquina(),
                command.getCategoria(),
                command.getMarca(),
                command.getSerial());

        emit().onResponse(new ResponseEvents(sede.getUncommittedChanges()));
    }
}
