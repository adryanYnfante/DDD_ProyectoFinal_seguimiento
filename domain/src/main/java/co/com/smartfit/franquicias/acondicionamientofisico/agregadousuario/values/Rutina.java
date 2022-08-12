package co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Rutina implements ValueObject<Rutina.Detalle> {

    private final String ejercicio;
    private final String serie;
    private final String repeticion;

    public Rutina(String ejercicio, String serie, String repeticion) {
        this.ejercicio = Objects.requireNonNull(ejercicio);
        this.serie = Objects.requireNonNull(serie);
        this.repeticion = Objects.requireNonNull(repeticion);
    }

    public static Rutina of(String ejercicio, String serie, String repeticion) {
        return new Rutina(ejercicio, serie, repeticion);
    }

    @Override
    public Detalle value() {
        return new Detalle(){
            @Override
            public String ejercicio(){return ejercicio;}
            @Override
            public String serie(){return serie;}
            @Override
            public String repeticion(){return repeticion;}
        };
    }

    public interface Detalle {
        String ejercicio();
        String serie();
        String repeticion();
    }
}
