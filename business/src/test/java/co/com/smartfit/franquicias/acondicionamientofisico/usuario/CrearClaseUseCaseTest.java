package co.com.smartfit.franquicias.acondicionamientofisico.usuario;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.commands.CrearClase;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.events.ClaseCreada;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values.ClaseId;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values.Duracion;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values.Rutina;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values.UsuarioId;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Nombre;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
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
class CrearClaseUseCaseTest {

    @InjectMocks
    private CrearClaseUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    public void crearClaseHappyPass(){
        //Arrange
        var command = new CrearClase(UsuarioId.of("Usuario-001"),
                ClaseId.of("Clase-0001"),
                Nombre.of("Spinning"),
                Rutina.of("Plancha", "5", "5"),
                Duracion.of(50));

        when(repository.getEventsBy("Usuario-001")).thenReturn(clases());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getUsuarioId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Asserts
        var claseCreada = (ClaseCreada)events.get(0);
        Assertions.assertEquals("Spinning", claseCreada.getNombreClase().value());
    }
    private List<DomainEvent> clases(){
        var event = new ClaseCreada(ClaseId.of("Clase-0001"),
                Nombre.of("Spinning"),
                Rutina.of("Plancha", "5", "5"),
                Duracion.of(50));

        event.setAggregateRootId("Usuario-001");
        return List.of(event);
    }

}