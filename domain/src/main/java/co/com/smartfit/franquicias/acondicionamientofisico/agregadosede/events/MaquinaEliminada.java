package co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.events;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.values.MaquinaId;
import co.com.sofka.domain.generic.DomainEvent;

public class MaquinaEliminada extends DomainEvent {
    private final MaquinaId maquinaId;
    public MaquinaEliminada(MaquinaId maquinaId) {
        super("co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.MaquinaEliminada");
        this.maquinaId = maquinaId;
    }

    public MaquinaId getMaquinaId() {
        return maquinaId;
    }
}
