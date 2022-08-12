package co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values;

import co.com.sofka.domain.generic.Identity;


public class EvaluacionFisicaId extends Identity {

    public EvaluacionFisicaId(String id) {
        super(id);
    }

    public EvaluacionFisicaId() {

    }

    public static EvaluacionFisicaId of(String id) {
        return new EvaluacionFisicaId(id);
    }
}