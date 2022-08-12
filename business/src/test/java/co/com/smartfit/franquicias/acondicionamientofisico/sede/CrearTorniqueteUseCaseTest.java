package co.com.smartfit.franquicias.acondicionamientofisico.sede;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.commands.CrearTorniquete;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.events.SedeCreada;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.events.TorniqueteCreado;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.values.*;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Nombre;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Serial;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Telefono;
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
class CrearTorniqueteUseCaseTest {

    @InjectMocks
    private CrearTorniqueteUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    public void crearTorniqueteHappyass() {
        //Arrange
        var command = new CrearTorniquete(SedeId.of("MED001"),
                TorniqueteId.of("0001"),
                LectorHuella.of("huella1"),
                Serial.of("T-11111")
        );

        when(repository.getEventsBy("MED001")).thenReturn(torniquetes());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getSedeId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Asserts
        var torniqueteCreado = (TorniqueteCreado) events.get(0);
        Assertions.assertEquals("MED001", torniqueteCreado.aggregateRootId());
//        Assertions.assertEquals("0001", torniqueteCreado.getTorniqueteId().value());
        Assertions.assertEquals("huella1", torniqueteCreado.getLectorHuella().value());
        Assertions.assertEquals("T-11111", torniqueteCreado.getSerial().value());
    }

    private List<DomainEvent> torniquetes() {

        var nombreSede = Nombre.of("Smart Fit Los Rocíos");
        var ciudadSede = Ciudad.of("Medellín");
        var direccionSede = Direccion.of("Calle 54AAA # 45 - 04");
        var telSede = Telefono.of("6046001020");

        var event = new SedeCreada(nombreSede, ciudadSede, direccionSede, telSede);

        event.setAggregateRootId("MED001");
        return List.of(event);
    }

}