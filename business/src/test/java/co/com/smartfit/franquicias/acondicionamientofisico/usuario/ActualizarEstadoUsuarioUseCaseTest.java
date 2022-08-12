package co.com.smartfit.franquicias.acondicionamientofisico.usuario;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.events.EstadoActualizado;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.events.UsuarioCreado;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.events.CuentaEliminada;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Estado;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values.UsuarioId;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Email;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Nombre;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Telefono;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarEstadoUsuarioUseCaseTest {

    @InjectMocks
    private ActualizarEstadoUsuarioUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void actualizarEstadoUsuarioHappyPass(){
        //Arrange
        var event = new CuentaEliminada(new Estado(Estado.Tipo.INACTIVO), UsuarioId.of("Usuario-001"));

        when(repository.getEventsBy("Usuario-001")).thenReturn(usuarios());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        //Asserts
        var estadoActualizado = (EstadoActualizado)events.get(0);
        Assertions.assertEquals(Estado.Tipo.INACTIVO, estadoActualizado.getEstado().value());
    }

    private List<DomainEvent> usuarios(){
        var event = new UsuarioCreado(UsuarioId.of("Usuario-001"),
                Nombre.of("Camilo Andrés Zuluaga"),
                Telefono.of("3113013030"),
                Email.of("juanK@usuario.com"));

        event.setAggregateRootId("Usuario-001");
        return List.of(event);
    }

}