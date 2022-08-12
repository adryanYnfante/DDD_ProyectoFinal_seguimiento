package co.com.smartfit.franquicias.acondicionamientofisico.services;

import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Estado;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadousuario.values.UsuarioId;

public interface ConsultarEstadoUsuario {
    Estado consultarPorUsuarioId(UsuarioId usuarioId);
}
