package co.com.smartfit.franquicias.acondicionamientofisico.agregadosede;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.values.Categoria;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.values.EstadoMantenimiento;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.values.MaquinaId;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.values.Marca;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Fecha;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Nombre;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Serial;
import co.com.sofka.domain.generic.Entity;

public class Maquina extends Entity<MaquinaId> {
    protected MaquinaId maquinaId;
    protected Nombre nombreMaquina;
    protected Categoria categoria;
    protected Marca marca;

    protected Serial serial;
    protected EstadoMantenimiento estadoMantenimiento;

    protected Fecha fecha;

    public Maquina(MaquinaId maquinaId, Nombre nombreMaquina,
                   Categoria categoria, Marca marca, Serial serial) {
        super(maquinaId);
        this.nombreMaquina = nombreMaquina;
        this.categoria = categoria;
        this.marca = marca;
        this.serial = serial;
    }

    public void asignarMaquinaAMantenimiento(MaquinaId maquinaId, Nombre nombreMaquina,
                                             Categoria categoria, Marca marca,
                                             Serial serial,
                                             EstadoMantenimiento estadoMantenimiento, Fecha fecha) {
        this.maquinaId = MaquinaId.of(marca.value());
        this.nombreMaquina = Nombre.of(nombreMaquina.value());
        this.categoria = Categoria.of(categoria.value());
        this.marca = Marca.of(marca.value());
        this.serial = Serial.of(serial.value());
        this.estadoMantenimiento = EstadoMantenimiento.of(estadoMantenimiento.value());
        this.fecha = fecha;
    }

    public void reemplazarMaquina(MaquinaId maquinaId, Nombre nombreMaquina,
                                  Categoria categoria, Marca marca, Serial serial,
                                  EstadoMantenimiento estadoMantenimiento){
        this.maquinaId = MaquinaId.of(marca.value());
        this.nombreMaquina = Nombre.of(nombreMaquina.value());
        this.categoria = Categoria.of(categoria.value());
        this.marca = Marca.of(marca.value());
        this.serial = Serial.of(serial.value());
        this.estadoMantenimiento = EstadoMantenimiento.of(estadoMantenimiento.value());
    }
}
