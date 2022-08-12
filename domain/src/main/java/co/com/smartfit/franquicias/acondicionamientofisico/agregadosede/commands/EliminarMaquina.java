package co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.commands;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.values.MaquinaId;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.values.SedeId;
import co.com.sofka.domain.generic.Command;

public class EliminarMaquina extends Command {
    private final SedeId sedeId;
    private final MaquinaId maquinaId;

    public EliminarMaquina(SedeId sedeId, MaquinaId maquinaId) {
        this.sedeId = sedeId;
        this.maquinaId = maquinaId;
    }

    public SedeId getSedeId() {
        return sedeId;
    }

    public MaquinaId getMaquinaId() {
        return maquinaId;
    }
}
