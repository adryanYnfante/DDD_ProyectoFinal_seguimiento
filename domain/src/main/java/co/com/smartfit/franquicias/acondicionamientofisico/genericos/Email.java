package co.com.smartfit.franquicias.acondicionamientofisico.genericos;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Email implements ValueObject<String> {

    private final String url;

    public Email(String url) {
        this.url = Objects.requireNonNull(url);

        if (this.url.isBlank()) {
            throw new IllegalArgumentException("La url no puede estar vacía");
        }

        if (this.url.length() > 100) {
            throw new IllegalArgumentException("La url no permite más de 100 carácteres");
        }

    }
    public static Email of(String url) {
        return new Email(url);
    }

    @Override
    public String value() {
        return url;
    }
}
