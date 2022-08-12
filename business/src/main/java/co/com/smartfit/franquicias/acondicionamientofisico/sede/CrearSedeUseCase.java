package co.com.smartfit.franquicias.acondicionamientofisico.sede;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.Sede;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.commands.CrearSede;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearSedeUseCase extends UseCase<RequestCommand<CrearSede>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearSede> crearSedeRequestCommand) {
        var command = crearSedeRequestCommand.getCommand();

        var sede = new Sede(command.getSedeId(),
                command.getNombreSede(),
                command.getCiudad(),
                command.getDireccion(),
                command.getTelefono()
        );
        emit().onResponse(new ResponseEvents(sede.getUncommittedChanges()));
    }
}
