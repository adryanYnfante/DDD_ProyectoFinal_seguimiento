package co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.commands;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.values.Categoria;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.values.MaquinaId;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.values.Marca;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.values.SedeId;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Nombre;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Serial;
import co.com.sofka.domain.generic.Command;

public class ReemplazarMaquina  extends Command {

    private final SedeId sedeId;
    private final MaquinaId maquinaId;
    private final Nombre nombreMaquina;
    private final Categoria categoria;
    private final Marca marca;
    private final Serial serial;

    public ReemplazarMaquina(SedeId sedeId, MaquinaId maquinaId,
                             Nombre nombreMaquina,
                             Categoria categoria, Marca marca,
                             Serial serial) {
        this.sedeId = sedeId;
        this.maquinaId = maquinaId;
        this.nombreMaquina = nombreMaquina;
        this.categoria = categoria;
        this.marca = marca;
        this.serial = serial;
    }

    public SedeId getSedeId() {
        return sedeId;
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
