package co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.events;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.values.Categoria;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.values.MaquinaId;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.values.Marca;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Fecha;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Nombre;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Serial;
import co.com.sofka.domain.generic.DomainEvent;

public class MaquinaAMantenimientoAsignada extends DomainEvent {

    private final MaquinaId maquinaId;
    private final Nombre nombreMaquina;
    private final Categoria categoria;
    private final Marca marca;
    private final Serial serial;
    private final Fecha fecha;

    public MaquinaAMantenimientoAsignada(MaquinaId maquinaId,
                                         Nombre nombreMaquina,
                                         Categoria categoria,
                                         Marca marca,
                                         Serial serial,
                                         Fecha fecha) {
        super("co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.MaquinaAMantenimientoAsignada");
        this.maquinaId = maquinaId;
        this.nombreMaquina = nombreMaquina;
        this.categoria = categoria;
        this.marca = marca;
        this.serial = serial;
        this.fecha = fecha;
    }

    public MaquinaId getMaquinaId() {
        return maquinaId;
    }

    public Nombre getNombreMaquina() {
        return nombreMaquina;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Marca getMarca() {
        return marca;
    }

    public Serial getSerial() {
        return serial;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
