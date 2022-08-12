package co.com.smartfit.franquicias.acondicionamientofisico.usuario;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.commands.CambiarNombreDeLaClase;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.events.ClaseCreada;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.events.NombreDeLaClaseCambiado;
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
class CambiarNombreDeLaClaseUseCaseTest {

    @InjectMocks
    private CambiarNombreDeLaClaseUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    public void cambiarNombreDeLaClaseHappyPass(){
        //Arrange
        var command = new CambiarNombreDeLaClase(UsuarioId.of("Usuario-001"),
                ClaseId.of("Clase-0001"),
                Nombre.of("GAP"));

        when(repository.getEventsBy("Usuario-001")).thenReturn(clases());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getUsuarioId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Asserts
        var cambio = (NombreDeLaClaseCambiado)events.get(0);
        Assertions.assertEquals("GAP", cambio.getNombreClase().value());
    }

    private List<DomainEvent> clases(){
        var event2 = new ClaseCreada(ClaseId.of("Clase-0001"),
                Nombre.of("Spinning"),
                Rutina.of("Plancha", "5", "5"),
                Duracion.of(50));

        event2.setAggregateRootId("Usuario-001");
        return List.of(event2);
    }

}