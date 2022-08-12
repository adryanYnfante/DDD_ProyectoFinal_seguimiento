package co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values;

import co.com.sofka.domain.generic.Identity;


public class ClaseId extends Identity {

    public ClaseId(String id) {
        super(id);
    }

    public ClaseId() {

    }

    public static ClaseId of(String id) {
        return new ClaseId(id);
    }
}
