package co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.values;

import co.com.sofka.domain.generic.Identity;

public class MaquinaId extends Identity {

    public MaquinaId(String id) {
        super(id);
    }

    public MaquinaId() {

    }

    public static MaquinaId of(String id) {
        return new MaquinaId(id);
    }
}
