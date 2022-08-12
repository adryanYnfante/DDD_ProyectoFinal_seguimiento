package co.com.smartfit.franquicias.acondicionamientofisico.personal;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.commands.CrearRecepcionista;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.events.RecepcionistaCreado;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.values.HorarioDeTrabajo;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.values.PersonalId;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.values.RecepcionistaId;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.DocumentoIdentidad;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Email;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Nombre;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Telefono;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CrearPersonalRecepcionistaUseCaseTest {

    private CrearPersonalRecepcionistaUseCase useCase;

    @BeforeEach
    public void setUp() {
        useCase = new CrearPersonalRecepcionistaUseCase();
    }

    @Test
    public void crearRecepcionistaHappyPass() {
        //Arrange
        var personalId = PersonalId.of("xxxxx");
        var recepcionistaId = RecepcionistaId.of("dddd");
        var nombreRecepcionista = Nombre.of("Cecilia Vélez");
        var documentoRecepcionista = DocumentoIdentidad.of(32100200L);
        var telefonoRecepcionista = Telefono.of("6046011010");
        var emailRecepcionista = Email.of("recepcion@recepcion");
        var horarioTrabajo = HorarioDeTrabajo.of("8 horas diarias");

        var command = new CrearRecepcionista(personalId, recepcionistaId, nombreRecepcionista,
                documentoRecepcionista, telefonoRecepcionista, emailRecepcionista, horarioTrabajo);

        //Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Asserts
        var recepcionistaCreado = (RecepcionistaCreado) events.get(0);
        Assertions.assertEquals("xxxxx", recepcionistaCreado.aggregateRootId());
        Assertions.assertEquals("dddd", recepcionistaCreado.getRecepcionistaId().value());
        Assertions.assertEquals("Cecilia Vélez", recepcionistaCreado.getNombreRecepcionista().value());
        Assertions.assertEquals(32100200L, recepcionistaCreado.getDocumentoRecepcionista().value());
        Assertions.assertEquals("6046011010", recepcionistaCreado.getTelefonoRecepcionista().value());
        Assertions.assertEquals("recepcion@recepcion", recepcionistaCreado.getEmailRecepcionista().value());
        Assertions.assertEquals("8 horas diarias", recepcionistaCreado.getHorarioDeTrabajo().value());
    }
}