package co.com.smartfit.franquicias.acondicionamientofisico.personal;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.Personal;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.commands.CrearMedico;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;


public class CrearPersonalMedicoUseCase extends UseCase<RequestCommand<CrearMedico>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearMedico> crearMedicoRequestCommand) {
        var command = crearMedicoRequestCommand.getCommand();

        var medico = new Personal(command.getPersonalId(),
                command.getMedicoId(),
                command.getNombreMedico(),
                command.getDocumentoMedico(),
                command.getTelefonoMedico(),
                command.getEmailMedico(),
                command.getDiasALaborar(),
                command.getCargo()
        );
        emit().onResponse(new ResponseEvents(medico.getUncommittedChanges()));
    }


}
