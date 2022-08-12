package co.com.smartfit.franquicias.acondicionamientofisico.agregadosede;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.values.EstadoMantenimiento;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.values.LectorHuella;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.values.TorniqueteId;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Serial;
import co.com.sofka.domain.generic.Entity;

public class Torniquete extends Entity<TorniqueteId> {
    protected TorniqueteId torniqueteId;
    protected LectorHuella lectorHuella;
    protected Serial serial;
    protected EstadoMantenimiento estadoMantenimiento;


    public Torniquete(TorniqueteId torniqueteId, LectorHuella lectorHuella,
                      Serial serial) {
        super(torniqueteId);
        this.lectorHuella = lectorHuella;
        this.serial = serial;
    }

    public void reemplazarTorniquete(TorniqueteId torniqueteId,
                                     LectorHuella lectorHuella,
                                     Serial serial,
                                     EstadoMantenimiento estadoMantenimiento) {
        this.torniqueteId = TorniqueteId.of(torniqueteId.value());
        this.lectorHuella = LectorHuella.of(lectorHuella.value());
        this.serial = Serial.of(serial.value());
        this.estadoMantenimiento = EstadoMantenimiento.of(estadoMantenimiento.value());

    }
}
