package co.com.smartfit.franquicias.acondicionamientofisico.sede;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.Sede;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.commands.AsignarMaquinaAMantenimiento;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AsignarMaquinaAMantenimientoUseCase extends UseCase<
        RequestCommand<AsignarMaquinaAMantenimiento>,
        ResponseEvents> {

    @Override
    public void executeUseCase(
            RequestCommand<AsignarMaquinaAMantenimiento>
                    asignarMaquinaAMantenimientoUseCaseRequestCommand) {
        var command = asignarMaquinaAMantenimientoUseCaseRequestCommand.getCommand();

        var sede = Sede.from(command.getSedeId(), repository().getEventsBy(command.getSedeId().value()));

        sede.asignarMaquinaAMantenimiento(command.getMaquinaId(),
                command.getNombreMaquina(),
                command.getCategoria(),
                command.getMarca(),
                command.getSerial(),
                command.getFecha()
                );

        emit().onResponse(new ResponseEvents(sede.getUncommittedChanges()));
    }
}
