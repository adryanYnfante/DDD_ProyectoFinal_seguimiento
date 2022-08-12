package co.com.smartfit.franquicias.acondicionamientofisico.sede;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.commands.EliminarMaquina;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.events.MaquinaCreada;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.events.MaquinaEliminada;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.values.Categoria;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.values.MaquinaId;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.values.Marca;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.values.SedeId;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Nombre;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Serial;
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
class EliminarMaquinaUseCaseTest {

    @InjectMocks
    private EliminarMaquinaUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void eliminarMaquinaHappyPass(){
        //Arrange
        var command = new EliminarMaquina(SedeId.of("MED001"), MaquinaId.of("0001"));
        when(repository.getEventsBy("MED001")).thenReturn(maquinasOut());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getSedeId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Asserts
        var maquinaEliminada = (MaquinaEliminada)events.get(0);
        Assertions.assertEquals("0001", maquinaEliminada.getMaquinaId().value());
    }

    private List<DomainEvent> maquinasOut(){
        var event = new MaquinaCreada(MaquinaId.of("0001"),
                Nombre.of("Elíptica"),
                Categoria.of("Cardio"),
                Marca.of("BodyMachine"),
                Serial.of("BM-010203"));

        event.setAggregateRootId("MED001");
        return List.of(event);
    }

}