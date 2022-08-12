package co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.values;

import co.com.sofka.domain.generic.Identity;


public class RecepcionistaId extends Identity {

    public RecepcionistaId(String id) {
        super(id);
    }

    public RecepcionistaId() {

    }

    public static RecepcionistaId of(String id) {
        return new RecepcionistaId(id);
    }
}
