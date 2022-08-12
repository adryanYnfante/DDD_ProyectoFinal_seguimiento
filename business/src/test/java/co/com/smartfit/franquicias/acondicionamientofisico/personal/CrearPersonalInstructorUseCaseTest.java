package co.com.smartfit.franquicias.acondicionamientofisico.personal;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.commands.CrearInstructor;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.events.InstructorCreado;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.values.Cantidad;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.values.InstructorId;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.values.PersonalId;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.DocumentoIdentidad;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Email;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Nombre;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Telefono;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CrearPersonalInstructorUseCaseTest {

    private CrearPersonalInstructorUseCase useCase;

    @BeforeEach
    public void setUp() {
        useCase = new CrearPersonalInstructorUseCase();
    }

    @Test
    public void crearInstructorHappyPass() {
        //Arrange
        var personalId = PersonalId.of("xxxxx");
        var instructorId = InstructorId.of("zzzz");
        var nombreInstructor = Nombre.of("Raúl Alzate");
        var documentoInstructor = DocumentoIdentidad.of(112233445566L);
        var telefonoInstructor = Telefono.of("3310310310");
        var emailInstructor = Email.of("instructor@instructor");
        var cantUsuarios = Cantidad.of("20");

        var command = new CrearInstructor(personalId, instructorId, nombreInstructor,
                documentoInstructor, telefonoInstructor, emailInstructor, cantUsuarios);

        //Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Asserts
        var instructorCreado = (InstructorCreado) events.get(0);
        Assertions.assertEquals("xxxxx", instructorCreado.aggregateRootId());
        Assertions.assertEquals("zzzz", instructorCreado.getInstructorId().value());
        Assertions.assertEquals("Raúl Alzate", instructorCreado.getNombreInstructor().value());
        Assertions.assertEquals(112233445566L, instructorCreado.getDocumentoInstructor().value());
        Assertions.assertEquals("3310310310", instructorCreado.getTelefonoInstructor().value());
        Assertions.assertEquals("instructor@instructor", instructorCreado.getEmailInstructor().value());
        Assertions.assertEquals("20", instructorCreado.getCantidadUsuarios().value());
    }
}