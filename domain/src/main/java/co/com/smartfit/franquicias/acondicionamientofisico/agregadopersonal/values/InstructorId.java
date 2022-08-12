package co.com.smartfit.franquicias.acondicionamientofisico.agregadopersonal.values;

import co.com.sofka.domain.generic.Identity;

public class InstructorId extends Identity {

    public InstructorId(String id) {
        super(id);
    }

    public InstructorId() {

    }

    public static InstructorId of(String id) {
        return new InstructorId(id);
    }
}
