package co.com.smartfit.franquicias.acondicionamientofisico.genericos;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Serial implements ValueObject<String> {

    private final String serial;

    public Serial(String serial) {
        this.serial = Objects.requireNonNull(serial);

        if (this.serial.isBlank()) {
            throw new IllegalArgumentException("El serial no puede estar en blanco.");
        }
    }

    public static Serial of(String serial) {
        return new Serial(serial);
    }

    @Override
    public String value() {
        return serial;
    }
}
