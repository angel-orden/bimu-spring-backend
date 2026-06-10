package com.angelorden.bimu.route;

import java.time.Instant;

public record RouteResponse(
        Long id,
        String title,
        String description,
        RouteDifficulty difficulty,
        Double distanceKm,
        String startLocation,
        Long creatorId,
        String creatorUsername,
        Instant createdAt
) {
}
