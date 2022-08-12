package co.com.smartfit.franquicias.acondicionamientofisico.usuario;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.commands.CrearUsuario;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.events.UsuarioCreado;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values.UsuarioId;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Email;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Nombre;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Telefono;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CrearUsuarioUseCaseTest {

    private CrearUsuarioUseCase useCase;

    @BeforeEach
    public void setUp(){
        useCase = new CrearUsuarioUseCase();
    }

    @Test
    public void crearUsuarioHappyPass(){
        //Arrange
        var command = new CrearUsuario(UsuarioId.of("Usuario001"),
                Nombre.of("Camilo Andrés Zuluaga"),
                Telefono.of("3113013030"),
                Email.of("juanK@usuario.com"));

        //Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Asserts
        var usuarioCreado = (UsuarioCreado)events.get(0);
        Assertions.assertEquals("Camilo Andrés Zuluaga", usuarioCreado.getNombreCompleto().value());
    }

}