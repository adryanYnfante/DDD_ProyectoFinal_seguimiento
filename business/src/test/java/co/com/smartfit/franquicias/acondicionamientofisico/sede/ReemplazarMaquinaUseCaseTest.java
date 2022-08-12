package co.com.smartfit.franquicias.acondicionamientofisico.sede;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.commands.ReemplazarMaquina;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.events.MaquinaCreada;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.events.MaquinaReemplazada;
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
class ReemplazarMaquinaUseCaseTest {

    @InjectMocks
    private ReemplazarMaquinaUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    public void reemplazarMaquinaHappyPass(){
        //Arrange
        var command = new ReemplazarMaquina(SedeId.of("MED001"),
                MaquinaId.of("0031"),
                Nombre.of("Estepper"),
                Categoria.of("Cardio"),
                Marca.of("BodyXT"),
                Serial.of("MC-0101005")
                );

        when(repository.getEventsBy("MED001")).thenReturn(reemplazosM());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getSedeId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Asserts
        var reemplazo = (MaquinaReemplazada)events.get(0);
        Assertions.assertEquals("Estepper", reemplazo.getNombreMaquina().value());
        Assertions.assertEquals("BodyXT", reemplazo.getMarca().value());
    }

    private List<DomainEvent> reemplazosM() {

        var event = new MaquinaCreada(MaquinaId.of("0031"),
                Nombre.of("Estepper"),
                Categoria.of("Cardio"),
                Marca.of("BodyXT"),
                Serial.of("MC-0101005"));

        event.setAggregateRootId("MED001");
        return List.of(event);
    }
}