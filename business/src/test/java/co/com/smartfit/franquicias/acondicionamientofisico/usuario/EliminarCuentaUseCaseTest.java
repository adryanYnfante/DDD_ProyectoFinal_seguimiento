package co.com.smartfit.franquicias.acondicionamientofisico.usuario;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.commands.EliminarCuenta;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.events.CuentaCreada;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.events.CuentaEliminada;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.events.UsuarioCreado;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values.*;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Email;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Estado;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Nombre;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Telefono;
import co.com.smartfit.franquicias.acondicionamientofisico.services.ConsultarEstadoUsuario;
import co.com.sofka.business.generic.ServiceBuilder;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EliminarCuentaUseCaseTest {

    @InjectMocks
    private EliminarCuentaUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Mock
    private ConsultarEstadoUsuario service;

    @Test
    void eliminarUsuarioHappyPass(){
        //Arrange
        var command = new EliminarCuenta(UsuarioId.of("Usuario-001"), Estado.of(Estado.Tipo.ACTIVO));
        when(repository.getEventsBy("Usuario-001")).thenReturn(cuentas());
        when(service.consultarPorUsuarioId(any(UsuarioId.class))).thenReturn(new Estado(Estado.Tipo.INACTIVO));
        useCase.addRepository(repository);
        useCase.addServiceBuilder(new ServiceBuilder().addService(service));

        //Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow().getDomainEvents();

        //Asserts
        var eliminado = (CuentaEliminada)events.get(0);
        Assertions.assertEquals(Estado.Tipo.INACTIVO, eliminado.getEstado().value());
    }

    private List<DomainEvent> cuentas(){
        var event = new UsuarioCreado(UsuarioId.of("Usuario-001"),
                Nombre.of("Camilo Andrés Zuluaga"),
                Telefono.of("3113013030"),
                Email.of("juanK@usuario.com"));
        event.setAggregateRootId("Usuario-001");

        var event1 = new CuentaCreada(CuentaId.of("cta01"),
                Mensualidad.of(150000D),
                Plan.of(Plan.Tipo.PLAN_BÁSICO));

        event1.setAggregateRootId("Usuario-001");
        return  List.of(event, event1);
    }

}