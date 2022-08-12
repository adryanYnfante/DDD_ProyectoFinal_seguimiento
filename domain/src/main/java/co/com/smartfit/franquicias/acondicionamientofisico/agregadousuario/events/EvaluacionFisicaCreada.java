package co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.events;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values.Altura;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values.EvaluacionFisicaId;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values.Peso;
import co.com.sofka.domain.generic.DomainEvent;

public class EvaluacionFisicaCreada extends DomainEvent {

    private final EvaluacionFisicaId evaluacionFisicaId;
    private final Peso peso;
    private final Altura altura;

    public EvaluacionFisicaCreada(EvaluacionFisicaId evaluacionFisicaId, Peso peso, Altura altura) {
        super("co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.EvaluacionFisicaCreada");
        this.evaluacionFisicaId = evaluacionFisicaId;
        this.peso = peso;
        this.altura = altura;
    }

    public Peso getPeso() {
        return peso;
    }

    public Altura getAltura() {
        return altura;
    }

}
