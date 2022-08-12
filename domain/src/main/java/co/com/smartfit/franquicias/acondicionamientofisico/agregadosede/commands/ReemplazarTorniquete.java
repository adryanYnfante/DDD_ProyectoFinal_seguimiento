package co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.commands;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.values.LectorHuella;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.values.SedeId;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.values.TorniqueteId;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Serial;
import co.com.sofka.domain.generic.Command;

public class ReemplazarTorniquete extends Command {

    private final SedeId sedeId;
    private final TorniqueteId torniqueteId;
    private final LectorHuella lectorHuella;
    private final Serial serial;

    public ReemplazarTorniquete(SedeId sedeId, TorniqueteId torniqueteId,
                                LectorHuella lectorHuella, Serial serial) {
        this.sedeId = sedeId;
        this.torniqueteId = torniqueteId;
        this.lectorHuella = lectorHuella;
        this.serial = serial;
    }

    public SedeId getSedeId() {
        return sedeId;
    }

    public TorniqueteId getTorniqueteId() {
        return torniqueteId;
    }

    public LectorHuella getLectorHuella() {
        return lectorHuella;
    }

    public Serial getSerial() {
        return serial;
    }
}
