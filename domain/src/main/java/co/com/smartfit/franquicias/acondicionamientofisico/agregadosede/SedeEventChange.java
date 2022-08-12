package co.com.smartfit.franquicias.acondicionamientofisico.agregadosede;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.events.*;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.values.EstadoMantenimiento;
import co.com.sofka.domain.generic.EventChange;

public class SedeEventChange extends EventChange {
    public SedeEventChange(Sede sede) {

        apply((SedeCreada event) -> {
            sede.nombreSede = event.getNombreSede();
            sede.ciudad = event.getCiudad();
            sede.direccion = event.getDireccion();
            sede.telefono = event.getTelefono();
        });

        apply((MaquinaCreada event) -> {
            var maquinaId = event.getMaquinaId();
            var nombreMaquina = event.getNombreMaquina();
            var categoria = event.getCategoria();
            var marca = event.getMarca();
            var serial = event.getSerial();

            sede.maquina = new Maquina(maquinaId, nombreMaquina, categoria, marca, serial);
        });

        apply((TorniqueteCreado event) -> {
            var torniqueteId = event.getTorniqueteId();
            var lectorHuella = event.getLectorHuella();
            var serial = event.getSerial();

            sede.torniquete = new Torniquete(torniqueteId, lectorHuella, serial);
        });

        apply((MaquinaAMantenimientoAsignada event) -> {
            sede.maquina.asignarMaquinaAMantenimiento(event.getMaquinaId(), event.getNombreMaquina(),
                    event.getCategoria(), event.getMarca(), event.getSerial(),
                    new EstadoMantenimiento(EstadoMantenimiento.Tipo.EN_MANTENIMIENTO), event.getFecha());
        });

        apply((TorniqueteReemplazado event) -> {
            sede.torniquete.reemplazarTorniquete(event.getTorniqueteId(),
                    event.getLectorHuella(),
                    event.getSerial(),
                    new EstadoMantenimiento(EstadoMantenimiento.Tipo.EN_BUEN_ESTADO));
        });

        apply((MaquinaReemplazada event) -> {
            sede.maquina.reemplazarMaquina(event.getMaquinaId(),
                    event.getNombreMaquina(),
                    event.getCategoria(),
                    event.getMarca(),
                    event.getSerial(),
                    new EstadoMantenimiento(EstadoMantenimiento.Tipo.EN_BUEN_ESTADO));
        });

        apply((TelefonoSedeCambiado event) -> {
            sede.telefono = event.getTelefono();
        });

        apply((MaquinaEliminada event) -> {
            sede.maquina = null;
        });
    }
}
