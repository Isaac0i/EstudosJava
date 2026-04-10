package com.isaac.school.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record StudentRequest(
        @NotBlank(message = "O nome é obrigatório")
        String name,

        @NotNull(message = "A matrícula é obrigatória")
        Integer registration
) {}
