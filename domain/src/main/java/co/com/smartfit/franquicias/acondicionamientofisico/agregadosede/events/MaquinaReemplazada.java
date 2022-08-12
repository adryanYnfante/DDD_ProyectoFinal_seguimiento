package co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.events;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.values.Categoria;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.values.MaquinaId;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.values.Marca;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Nombre;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Serial;
import co.com.sofka.domain.generic.DomainEvent;

public class MaquinaReemplazada extends DomainEvent {
    private final MaquinaId maquinaId;
    private final Nombre nombreMaquina;
    private final Categoria categoria;
    private final Marca marca;
    private final Serial serial;


    public MaquinaReemplazada(MaquinaId maquinaId, Nombre nombreMaquina,
                              Categoria categoria, Marca marca, Serial serial) {
        super("co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.MaquinaReemplazada");
        this.maquinaId = MaquinaId.of(maquinaId.value());
        this.nombreMaquina = Nombre.of(nombreMaquina.value());
        this.categoria = Categoria.of(categoria.value());
        this.marca = Marca.of(marca.value());
        this.serial = Serial.of(serial.value());
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
}
