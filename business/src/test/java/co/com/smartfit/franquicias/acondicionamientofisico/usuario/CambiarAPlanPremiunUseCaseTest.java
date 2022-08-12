package co.com.smartfit.franquicias.acondicionamientofisico.usuario;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.commands.CambiarAPlanPremiun;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.events.CuentaCreada;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.events.PlanCambiadoAPremiun;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.events.UsuarioCreado;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values.CuentaId;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values.Mensualidad;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values.Plan;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values.UsuarioId;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Email;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Nombre;
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
class CambiarAPlanPremiunUseCaseTest {

    @InjectMocks
    private CambiarAPlanPremiunUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void cambiarAPlanPremiunHappyPass(){
        //Arrange
        var command = new CambiarAPlanPremiun(UsuarioId.of("Usuario-001"),
                CuentaId.of("Cta-002"),
                Mensualidad.of(230500D),
                Plan.of(Plan.Tipo.PLAN_PREMIUN));

        when(repository.getEventsBy("Usuario-001")).thenReturn(usuarios());

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getUsuarioId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Asserts
        var planPremiun = (PlanCambiadoAPremiun)events.get(0);
        Assertions.assertEquals(Plan.Tipo.PLAN_PREMIUN, planPremiun.getPlan().value());
    }

    private List<DomainEvent> usuarios(){
        var event1 = new UsuarioCreado(UsuarioId.of("Usuario001"),
                Nombre.of("Camilo Andrés Zuluaga"),
                Telefono.of("3113013030"),
                Email.of("juanK@usuario.com"));

        event1.setAggregateRootId("Usuario-001");

        var event2 = new CuentaCreada(CuentaId.of("Cta-001"),
                Mensualidad.of(150000D),
                Plan.of(Plan.Tipo.PLAN_BÁSICO));

        event2.setAggregateRootId("Usuario-001");

        return List.of(event1, event2);
    }

}