package co.com.smartfit.franquicias.acondicionamientofisico.sede;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.Sede;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.commands.CambiarTelefonoSede;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CambiarTelefonoSedeUseCase extends UseCase<RequestCommand<CambiarTelefonoSede>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarTelefonoSede> cambiarTelefonoSedeRequestCommand) {
        var command = cambiarTelefonoSedeRequestCommand.getCommand();

        var sede = Sede.from(command.getSedeId(), repository().getEventsBy(command.getSedeId().value()));

        sede.cambiarTelefonoSede(command.getSedeId(), command.getTelefono());

        emit().onResponse(new ResponseEvents(sede.getUncommittedChanges()));
    }
}
