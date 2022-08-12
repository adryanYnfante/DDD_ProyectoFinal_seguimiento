package co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values;

import co.com.sofka.domain.generic.Identity;

public class CuentaId extends Identity {

    public CuentaId(String id) {
        super(id);
    }

    public CuentaId() {

    }

    public static CuentaId of(String id) {
        return new CuentaId(id);
    }
}
