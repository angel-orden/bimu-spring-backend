package com.angelorden.bimu.route;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CreateRouteRequest(
        @NotBlank
        String title,

        @NotBlank
        String description,

        @NotNull
        RouteDifficulty difficulty,

        @NotNull
        @Positive
        Double distanceKm,

        @NotBlank
        String startLocation
) {
}
