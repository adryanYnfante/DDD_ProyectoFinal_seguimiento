package co.com.smartfit.franquicias.acondicionamientofisico.sede;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.commands.ReemplazarTorniquete;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.events.TorniqueteCreado;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.events.TorniqueteReemplazado;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.values.LectorHuella;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.values.SedeId;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.values.TorniqueteId;
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
class ReemplazarTorniqueteUseCaseTest {

    @InjectMocks
    private ReemplazarTorniqueteUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    public void reemplazarTorniqueteHappyPass(){
        //Arrange
        var command = new ReemplazarTorniquete(SedeId.of("MED001"),
                TorniqueteId.of("0002"),
                LectorHuella.of("Huella-2"),
                Serial.of("T-010105N")
                );

        when(repository.getEventsBy("MED001")).thenReturn(reemplazosT());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getSedeId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Asserts
        var reemplazo = (TorniqueteReemplazado)events.get(0);
        Assertions.assertEquals("T-010105N", reemplazo.getSerial().value());
    }

    private List<DomainEvent> reemplazosT() {

        var event = new TorniqueteCreado(TorniqueteId.of("0002"),
                LectorHuella.of("Huella-2"),
                Serial.of("T-010105N"));

        event.setAggregateRootId("MED001");
        return List.of(event);
    }
}