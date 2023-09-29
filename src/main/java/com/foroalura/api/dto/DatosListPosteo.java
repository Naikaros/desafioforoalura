package com.foroalura.api.dto;

import com.foroalura.api.modelo.EstadoPosteo;
import com.foroalura.api.modelo.Posteo;

import java.util.Date;

public record DatosListPosteo(String titulo, String mensaje, Date fechaCreacion,
                              EstadoPosteo estadoPosteos, String autor, String curso) {
    public DatosListPosteo(Posteo posteo) {
        this(posteo.getTitulo(), posteo.getMensaje(), posteo.getFechaCreacion(),
        posteo.getEstadoPosteo(), posteo.getAutor(), posteo.getCurso());
    }
}
