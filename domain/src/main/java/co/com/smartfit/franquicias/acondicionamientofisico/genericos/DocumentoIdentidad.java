package co.com.smartfit.franquicias.acondicionamientofisico.genericos;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class DocumentoIdentidad implements ValueObject<Long> {

    private final Long numeroDocumento;

    public DocumentoIdentidad(Long numeroDocumento) {

        this.numeroDocumento = Objects.requireNonNull(numeroDocumento);

        if (String.valueOf(this.numeroDocumento).isBlank()) {
            throw new IllegalArgumentException("El número de documento no puede estar vacío");
        }

        if (!this.numeroDocumento.equals(this.numeroDocumento.longValue())) {
            throw new IllegalArgumentException("El número de documento no puede tener decimales");
        }
    }

    public static DocumentoIdentidad of(Long numeroDocumento) {
        return new DocumentoIdentidad(numeroDocumento);
    }

    @Override
    public Long value() {
        return numeroDocumento;
    }
}
