package co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.commands;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values.Altura;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values.EvaluacionFisicaId;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values.Peso;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values.UsuarioId;
import co.com.sofka.domain.generic.Command;

public class CrearEvaluacionFisica extends Command {
    private final UsuarioId usuarioId;
    private final EvaluacionFisicaId evaluacionFisicaId;
    private final Peso peso;
    private final Altura altura;

    public CrearEvaluacionFisica(UsuarioId usuarioId, EvaluacionFisicaId evaluacionFisicaId,
                                 Peso peso, Altura altura) {
        this.usuarioId = usuarioId;
        this.evaluacionFisicaId = evaluacionFisicaId;
        this.peso = peso;
        this.altura = altura;
    }

    public UsuarioId getUsuarioId() {
        return usuarioId;
    }

    public Peso getPeso() {
        return peso;
    }

    public Altura getAltura() {
        return altura;
    }

}
