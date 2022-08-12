package co.com.smartfit.franquicias.acondicionamientofisico.usuario;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.commands.CrearEvaluacionFisica;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.events.EvaluacionFisicaCreada;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values.Altura;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values.EvaluacionFisicaId;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values.Peso;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values.UsuarioId;
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
class CrearEvaluacionFisicaUseCaseTest {
    @InjectMocks
    private CrearEvaluacionFisicaUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    public void crearEvaluacionFisica(){
        //Arrange
        var command = new CrearEvaluacionFisica(UsuarioId.of("Usuario-001"),
                EvaluacionFisicaId.of("EV-FIS-001"),
                Peso.of(105.5D),
                Altura.of(1.70D));

        when(repository.getEventsBy("Usuario-001")).thenReturn(evaluaciones());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getUsuarioId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Asserts
        var evaluacionCreada = (EvaluacionFisicaCreada)events.get(0);
        Assertions.assertEquals(105.5D, evaluacionCreada.getPeso().value());
    }

    private List<DomainEvent> evaluaciones(){
        var event = new EvaluacionFisicaCreada(EvaluacionFisicaId.of("EV-FIS-001"),
                Peso.of(105.5D),
                Altura.of(1.70D));

        event.setAggregateRootId("Usuario-001");
        return List.of(event);
    }
}