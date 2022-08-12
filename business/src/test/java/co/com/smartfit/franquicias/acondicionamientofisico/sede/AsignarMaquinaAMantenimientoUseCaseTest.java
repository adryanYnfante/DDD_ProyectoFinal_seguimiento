package co.com.smartfit.franquicias.acondicionamientofisico.sede;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.commands.AsignarMaquinaAMantenimiento;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.events.MaquinaAMantenimientoAsignada;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.events.MaquinaCreada;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.values.Categoria;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.values.MaquinaId;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.values.Marca;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.values.SedeId;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Fecha;
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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AsignarMaquinaAMantenimientoUseCaseTest {

    @InjectMocks
    private AsignarMaquinaAMantenimientoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    public void asignarMaquinaAMantenimiento(){
        //Arrange
        var commmand = new AsignarMaquinaAMantenimiento(
                SedeId.of("MED001"),
                MaquinaId.of("0002"),
                Nombre.of("Prensa de piernas"),
                Categoria.of("Piernas"),
                Marca.of("ExerBody"),
                Serial.of("EX-01005P"),
                Fecha.of(LocalDateTime.now(), LocalDate.now()));

        when(repository.getEventsBy("MED001")).thenReturn(mantenimientos());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(commmand.getSedeId().value())
                .syncExecutor(useCase, new RequestCommand<>(commmand))
                .orElseThrow()
                .getDomainEvents();

        //Asserts
        var asignacion = (MaquinaAMantenimientoAsignada) events.get(0);
        Assertions.assertEquals("MED001", asignacion.aggregateRootId());
        Assertions.assertEquals("Prensa de piernas", asignacion.getNombreMaquina().value());
        Assertions.assertEquals("Piernas", asignacion.getCategoria().value());
        Assertions.assertEquals("ExerBody", asignacion.getMarca().value());
        Assertions.assertEquals("EX-01005P", asignacion.getSerial().value());
    }

    private List<DomainEvent> mantenimientos() {

        var event = new MaquinaCreada(MaquinaId.of("0002"),
                Nombre.of("Prensa de piernas"),
                Categoria.of("Piernas"),
                Marca.of("ExerBody"),
                Serial.of("EX-01005P"));

        event.setAggregateRootId("MED001");
        return List.of(event);
    }

}