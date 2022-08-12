package co.com.smartfit.franquicias.acondicionamientofisico.sede;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.commands.CrearMaquina;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.events.MaquinaCreada;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.events.SedeCreada;
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
class CrearMaquinaUseCaseTest {

    @InjectMocks
    private CrearMaquinaUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    public void crearMaquinaHappyPass() {
        //Arrange
        var command = new CrearMaquina(SedeId.of("MED001"),
                MaquinaId.of("0001"),
                Nombre.of("Elíptica"),
                Categoria.of("Cardio"),
                Marca.of("BodyMachine"),
                Serial.of("BM-010203"));

        when(repository.getEventsBy("MED001")).thenReturn(history());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getSedeId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Asserts
        var maquinaCreada = (MaquinaCreada) events.get(0);
        Assertions.assertEquals("MED001", maquinaCreada.aggregateRootId());
//        Assertions.assertEquals("0001", maquinaCreada.getMaquinaId().value());
        Assertions.assertEquals("Elíptica", maquinaCreada.getNombreMaquina().value());
        Assertions.assertEquals("Cardio", maquinaCreada.getCategoria().value());
        Assertions.assertEquals("BodyMachine", maquinaCreada.getMarca().value());
        Assertions.assertEquals("BM-010203", maquinaCreada.getSerial().value());
    }

    private List<DomainEvent> history() {

        var nombreSede = Nombre.of("Smart Fit Los Rocíos");
        var ciudadSede = Ciudad.of("Medellín");
        var direccionSede = Direccion.of("Calle 54AAA # 45 - 04");
        var telSede = Telefono.of("6046001020");

        var event = new SedeCreada(nombreSede, ciudadSede, direccionSede, telSede);

        event.setAggregateRootId("MED001");
        return List.of(event);
    }
}