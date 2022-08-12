package co.com.smartfit.franquicias.acondicionamientofisico.sede;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.commands.CambiarTelefonoSede;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.events.SedeCreada;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.events.TelefonoSedeCambiado;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.values.Ciudad;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.values.Direccion;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.values.SedeId;
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
class CambiarTelefonoSedeUseCaseTest {

    @InjectMocks
    private CambiarTelefonoSedeUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    public void cambiarTelefonoSedeHappyPass(){
        //Arrange
        var command = new CambiarTelefonoSede(SedeId.of("MED001"),
                Telefono.of("6044010510"));

        when(repository.getEventsBy("MED001")).thenReturn(sedes());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getSedeId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Asserts
        var telefono = (TelefonoSedeCambiado)events.get(0);
        Assertions.assertEquals("6044010510", telefono.getTelefono().value());
    }

    private List<DomainEvent> sedes() {

        var nombreSede = Nombre.of("Smart Fit Los Rocíos");
        var ciudadSede = Ciudad.of("Medellín");
        var direccionSede = Direccion.of("Calle 54AAA # 45 - 04");
        var telSede = Telefono.of("6046001020");

        var event = new SedeCreada(nombreSede, ciudadSede, direccionSede, telSede);

        event.setAggregateRootId("MED001");
        return List.of(event);
    }

}