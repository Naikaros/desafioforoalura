package com.foroalura.api.dto;


import jakarta.validation.constraints.NotBlank;
public record DatosNuevoPosteo(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotBlank
        String autor,
        @NotBlank
        String curso
) {
}
