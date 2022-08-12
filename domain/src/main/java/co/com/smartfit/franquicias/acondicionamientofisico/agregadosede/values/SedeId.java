package co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.values;

import co.com.sofka.domain.generic.Identity;

public class SedeId extends Identity {

    public SedeId(String id) {
        super(id);
    }

    public SedeId() {

    }

    public static SedeId of(String id) {
        return new SedeId(id);
    }
}
