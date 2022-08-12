package co.com.smartfit.franquicias.acondicionamientofisico.usuario;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.commands.CrearCuenta;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.events.CuentaCreada;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values.CuentaId;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values.Mensualidad;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values.Plan;
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
class CrearCuentaUseCaseTest {

    @InjectMocks
    private CrearCuentaUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    public void crearCuentaHappyPass(){
        //Arrange
        var command = new CrearCuenta(UsuarioId.of("Usuario-001"),
                CuentaId.of("cta01"),
                Mensualidad.of(150000D),
                Plan.of(Plan.Tipo.PLAN_BÁSICO)
                );

        when(repository.getEventsBy("Usuario-001")).thenReturn(usuarios());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getUsuarioId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //Asserts
        var cuentaCreada = (CuentaCreada)events.get(0);
        Assertions.assertEquals(Plan.Tipo.PLAN_BÁSICO, cuentaCreada.getPlan().value());
    }

    private List<DomainEvent> usuarios(){
        var event = new CuentaCreada(CuentaId.of("cta01"),
                Mensualidad.of(150000D),
                Plan.of(Plan.Tipo.PLAN_BÁSICO));

        event.setAggregateRootId("Usuario-001");
        return List.of(event);
    }

}