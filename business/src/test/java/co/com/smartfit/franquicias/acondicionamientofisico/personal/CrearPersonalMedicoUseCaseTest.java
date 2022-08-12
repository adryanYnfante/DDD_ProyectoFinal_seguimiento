package co.com.smartfit.franquicias.acondicionamientofisico.personal;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.commands.CrearMedico;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.events.MedicoCreado;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.values.Cargo;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.values.DiasALaborar;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.values.MedicoId;
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

class CrearPersonalMedicoUseCaseTest {

    private CrearPersonalMedicoUseCase useCase;

    @BeforeEach
    public void setUp() {
        useCase = new CrearPersonalMedicoUseCase();
    }

    @Test
    public void crearMedicoHappyPass() {
        //Arrange
        var personalId = PersonalId.of("xxxxx");
        var medicoId = MedicoId.of("yyyy");
        var nombreMedico = Nombre.of("Doris Mosquera");
        var documentoMedico = DocumentoIdentidad.of(102030405060L);
        var telefonoMedico = Telefono.of("3163161616");
        var emailMedico = Email.of("medico@medico");
        var diasLabor = DiasALaborar.of("5");
        var cargo = Cargo.of(Cargo.Tipo.POR_DEFINIR);

        var command = new CrearMedico(personalId, medicoId, nombreMedico,
                documentoMedico, telefonoMedico, emailMedico, diasLabor, cargo);

        //Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Asserts
        var medicoCreado = (MedicoCreado) events.get(0);
        Assertions.assertEquals("xxxxx", medicoCreado.aggregateRootId());
        Assertions.assertEquals("yyyy", medicoCreado.getMedicoId().value());
        Assertions.assertEquals("Doris Mosquera", medicoCreado.getNombreMedico().value());
        Assertions.assertEquals(102030405060L, medicoCreado.getDocumentoMedico().value());
        Assertions.assertEquals("3163161616", medicoCreado.getTelefonoMedico().value());
        Assertions.assertEquals("medico@medico", medicoCreado.getEmailMedico().value());
        Assertions.assertEquals("5", medicoCreado.getDiasALaborar().value());
    }

}