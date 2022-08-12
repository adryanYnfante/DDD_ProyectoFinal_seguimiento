package co.com.smartfit.franquicias.acondicionamientofisico.usuario;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.Usuario;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.events.CuentaEliminada;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;

public class ActualizarEstadoUsuarioUseCase extends UseCase<TriggeredEvent<CuentaEliminada>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<CuentaEliminada> cuentaEliminadaTriggeredEvent) {
        var event = cuentaEliminadaTriggeredEvent.getDomainEvent();
        var usuario = Usuario.from(event.getUsuarioId(), repository().getEventsBy(event.getUsuarioId().value()));

        usuario.actualizarEstado(event.getEstado());

        emit().onResponse(new ResponseEvents(usuario.getUncommittedChanges()));
    }
}
