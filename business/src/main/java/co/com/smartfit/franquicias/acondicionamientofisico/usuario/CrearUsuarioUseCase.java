package co.com.smartfit.franquicias.acondicionamientofisico.usuario;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.Usuario;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.commands.CrearUsuario;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearUsuarioUseCase extends UseCase<RequestCommand<CrearUsuario>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearUsuario> crearUsuarioRequestCommand) {
        var command = crearUsuarioRequestCommand.getCommand();

        var usuario = new Usuario(command.getUsuarioId(),
                command.getNombreUsuario(),
                command.getTelefono(),
                command.getEmail());

        emit().onResponse(new ResponseEvents(usuario.getUncommittedChanges()));
    }
}
