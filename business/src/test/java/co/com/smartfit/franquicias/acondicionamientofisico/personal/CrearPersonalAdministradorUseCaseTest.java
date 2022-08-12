package co.com.smartfit.franquicias.acondicionamientofisico.personal;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.commands.CrearAdministrador;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.events.AdministradorCreado;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.values.AdministradorId;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.values.PersonalId;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.values.Promocion;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.DocumentoIdentidad;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Email;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Nombre;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Telefono;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CrearPersonalAdministradorUseCaseTest {

    private CrearPersonalAdministradorUseCase useCase;

    @BeforeEach
    public void setUp() {
        useCase = new CrearPersonalAdministradorUseCase();
    }

    @Test
    public void crearAdministradorHappyPass() {
        //Arrange
        var personalId = PersonalId.of("xxxxx");
        var administradorId = AdministradorId.of("qqqq");
        var nombreAdministrador = Nombre.of("Manuel Salas");
        var documentoAdministrador = DocumentoIdentidad.of(1346798552L);
        var telefonoAdministrador = Telefono.of("3003013233");
        var emailAdministrador = Email.of("admin@admin");
        var promocion = Promocion.of("Por esta semana 2x1 durante 3 meses. Trae tu referido");

        var command = new CrearAdministrador(personalId, administradorId, nombreAdministrador,
                documentoAdministrador, telefonoAdministrador, emailAdministrador, promocion);

        //Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Asserts
        var administradorCreado = (AdministradorCreado) events.get(0);
        Assertions.assertEquals("xxxxx", administradorCreado.aggregateRootId());
        Assertions.assertEquals("qqqq", administradorCreado.getAdministradorId().value());
        Assertions.assertEquals("Manuel Salas", administradorCreado.getNombreAdministrador().value());
        Assertions.assertEquals(1346798552L, administradorCreado.getDocumentoAdministrador().value());
        Assertions.assertEquals("3003013233", administradorCreado.getTelefonoAdministrador().value());
        Assertions.assertEquals("admin@admin", administradorCreado.getEmailAdministrador().value());
        Assertions.assertEquals("Por esta semana 2x1 durante 3 meses. Trae tu referido", administradorCreado.getPromocion().value());
    }
}