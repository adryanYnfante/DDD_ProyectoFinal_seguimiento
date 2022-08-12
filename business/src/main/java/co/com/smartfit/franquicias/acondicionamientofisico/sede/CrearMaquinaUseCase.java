package co.com.smartfit.franquicias.acondicionamientofisico.sede;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.Sede;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.commands.CrearMaquina;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearMaquinaUseCase extends UseCase<RequestCommand<CrearMaquina>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearMaquina> crearMaquinaRequestCommand) {
        var command = crearMaquinaRequestCommand.getCommand();

        var sede = Sede.from(command.getSedeId(), repository().getEventsBy(command.getSedeId().value()));

        sede.crearMaquina(command.getNombreMaquina(),
                command.getCategoria(),
                command.getMarca(),
                command.getSerial()
        );
        emit().onResponse(new ResponseEvents(sede.getUncommittedChanges()));
    }
}
