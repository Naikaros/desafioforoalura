package com.foroalura.api.dto;

import jakarta.validation.constraints.NotNull;

public record DatosEditPosteo(@NotNull Long id, String titulo, String mensaje, String autor,
                              String curso) {
}
