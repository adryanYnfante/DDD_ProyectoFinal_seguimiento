package co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.values;

import co.com.sofka.domain.generic.Identity;

public class AdministradorId extends Identity {

    public AdministradorId(String id) {
        super(id);
    }

    public AdministradorId() {

    }

    public static AdministradorId of(String id) {
        return new AdministradorId(id);
    }
}
