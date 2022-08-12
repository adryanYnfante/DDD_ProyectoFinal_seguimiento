package co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.values;

import co.com.sofka.domain.generic.Identity;

public class TorniqueteId extends Identity {

    public TorniqueteId(String id) {
        super(id);
    }

    public TorniqueteId() {

    }

    public static TorniqueteId of(String id) {
        return new TorniqueteId(id);
    }
}
