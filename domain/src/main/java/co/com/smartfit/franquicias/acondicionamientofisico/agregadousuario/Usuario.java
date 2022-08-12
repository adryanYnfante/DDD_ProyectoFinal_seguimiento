package co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.events.*;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values.*;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Email;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Estado;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Nombre;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Telefono;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

public class Usuario extends AggregateEvent<UsuarioId> {
    protected UsuarioId usuarioId;
    protected Nombre nombre;
    protected Telefono telefono;
    protected Email email;
    protected Estado estado;
    protected EvaluacionFisica evaluacionFisica;
    protected Clase clase;
    protected Cuenta cuenta;

    public Usuario(UsuarioId usuarioId, Nombre nombre, Telefono telefono, Email email) {
        super(usuarioId);
        appendChange(new UsuarioCreado(usuarioId, nombre, telefono, email)).apply();
        subscribe(new UsuarioEventChange(this));
    }

    private Usuario(UsuarioId usuarioId) {
        super(usuarioId);
        subscribe(new UsuarioEventChange(this));
    }

    public static Usuario from(UsuarioId usuarioId, List<DomainEvent> events) {
        var usuario = new Usuario(usuarioId);
        events.forEach(usuario::applyEvent);
        return usuario;
    }

    public void crearCuenta(Mensualidad mensualidad, Plan plan) {
        var cuentaId = new CuentaId();
        appendChange(new CuentaCreada(cuentaId, mensualidad, plan)).apply();
    }

    public void crearClase(Nombre nombreClase,
                           Rutina rutina,
                           Duracion duracion) {
        var claseId = new ClaseId();
        appendChange(new ClaseCreada(claseId, nombreClase, rutina, duracion)).apply();
    }

    public void crearEvaluacionFisica(Peso peso, Altura altura) {
        var evaluacionFisicaId = new EvaluacionFisicaId();
        appendChange(new EvaluacionFisicaCreada(evaluacionFisicaId, peso, altura)).apply();
    }

    public void asignarEstadoUsuario(UsuarioId usuarioId, Estado estado) {
        appendChange(new EstadoUsuarioAsignado(usuarioId, estado)).apply();
    }

    public void cambiarAPlanGold(CuentaId cuentaId, Mensualidad mensualidad, Plan plan) {
        appendChange(new PlanCambiadoAGold(cuentaId, mensualidad, plan)).apply();
    }

    public void cambiarAPlanPremiun(CuentaId cuentaId, Mensualidad mensualidad, Plan plan) {
        appendChange(new PlanCambiadoAPremiun(cuentaId, mensualidad, plan)).apply();
    }

    public void calcularIMC(EvaluacionFisicaId evaluacionFisicaId, Peso peso, Altura altura) {
        appendChange(new IMCCalculado(evaluacionFisicaId, peso, altura)).apply();
    }

    public void cambiarNombreDeLaClase(ClaseId claseId, Nombre nombreClase) {
        appendChange(new NombreDeLaClaseCambiado(claseId, nombreClase)).apply();
    }

    public void eliminarCuenta(Estado estado){
        appendChange(new CuentaEliminada(estado, usuarioId)).apply();
    }

    public void actualizarEstado(Estado estado){
        appendChange(new EstadoActualizado(estado)).apply();
    }

}
