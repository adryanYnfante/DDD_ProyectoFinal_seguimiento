package co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.events.*;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values.*;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Estado;
import co.com.sofka.domain.generic.EventChange;

public class UsuarioEventChange extends EventChange {
    public UsuarioEventChange(Usuario usuario) {

        apply((UsuarioCreado event) -> {
            usuario.nombre = event.getNombreCompleto();
            usuario.telefono = event.getTelefono();
            usuario.email = event.getEmail();
            usuario.estado = new Estado(Estado.Tipo.ACTIVO);
        });

        apply((CuentaCreada event) -> {

            var cuenta = new Cuenta(event.getCuentaId(), event.getMensualidad(),
                    new Plan(Plan.Tipo.PLAN_BÁSICO));
        });

        apply((ClaseCreada event) -> {
            var claseId = new ClaseId();
            var clase = new Clase(claseId, event.getNombreClase(),
                    event.getRutina(),
                    event.getDuracion());
        });

        apply((EvaluacionFisicaCreada event) -> {
            var evFisId = new EvaluacionFisicaId();
            usuario.evaluacionFisica = new EvaluacionFisica(evFisId, event.getPeso(), event.getAltura());

        });

        apply((PlanCambiadoAGold event) -> {
            var cuentaId = new CuentaId();
            var nuevoPlan = new Cuenta(cuentaId, event.getMensualidad(), new Plan(Plan.Tipo.PLAN_GOLD));
            //usuario.cuenta.plan = usuario.cuenta.cambiarAPlanGold(cuentaId, new Plan(Plan.Tipo.PLAN_GOLD));
        });

        apply((PlanCambiadoAPremiun event) -> {
            var cuentaId = event.getCuentaId();
            var nuevoPlan = new Cuenta(cuentaId, event.getMensualidad(), new Plan(Plan.Tipo.PLAN_PREMIUN));
        });

        apply((EstadoUsuarioAsignado event) -> {
            var cuentaId = event.getUsuarioId();
            var estado = new Estado(Estado.Tipo.INACTIVO);
            usuario.asignarEstadoUsuario(cuentaId, estado);
        });

        apply((IMCCalculado event) -> {
            var evaluacionFisicaId = event.getEvaluacionFisicaId();
            var peso = event.getPeso();
            var altura = event.getAltura();

            usuario.evaluacionFisica.calcularIMC(peso, altura);
        });

        apply((NombreDeLaClaseCambiado event) -> {
            var claseId = new ClaseId();
            var nuevaClase = new Clase(claseId, event.getNombreClase());
        });

        apply((CuentaEliminada event) -> {
            usuario.estado = event.getEstado();
            usuario.cuenta = null;
        });

    }
}
