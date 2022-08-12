package co.com.smartfit.franquicias.acondicionamientofisico.sede;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.commands.CrearSede;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.events.SedeCreada;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.values.Ciudad;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.values.Direccion;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.values.SedeId;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Nombre;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Telefono;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CrearSedeUseCaseTest {

    private CrearSedeUseCase useCase;

    @BeforeEach
    public void setUp() {
        useCase = new CrearSedeUseCase();
    }

    @Test
    public void crearSedeHappyPass() {
        //Arrange
        var sedeId = SedeId.of("MED001");
        var nombreSede = Nombre.of("Smart Fit Los Rocíos");
        var ciudadSede = Ciudad.of("Medellín");
        var direccionSede = Direccion.of("Calle 54AAA # 45 - 04");
        var telSede = Telefono.of("6046001020");

        var command = new CrearSede(sedeId, nombreSede, ciudadSede, direccionSede, telSede);
        //Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Asserts
        var sedeCreada = (SedeCreada) events.get(0);
        Assertions.assertEquals("MED001", sedeCreada.aggregateRootId());
        Assertions.assertEquals("Smart Fit Los Rocíos", sedeCreada.getNombreSede().value());
        Assertions.assertEquals("Medellín", sedeCreada.getCiudad().value());
        Assertions.assertEquals("Calle 54AAA # 45 - 04", sedeCreada.getDireccion().value());
        Assertions.assertEquals("6046001020", sedeCreada.getTelefono().value());
    }

}