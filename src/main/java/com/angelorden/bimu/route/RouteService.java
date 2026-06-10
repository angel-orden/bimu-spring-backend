package com.angelorden.bimu.route;

import com.angelorden.bimu.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RouteService {

    private final RouteRepository routeRepository;

    public List<RouteResponse> findAll() {
        return routeRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public RouteResponse findById(Long id) {
        Route route = routeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Route not found"));

        return toResponse(route);
    }

    public RouteResponse create(CreateRouteRequest request, User creator) {
        Route route = Route.builder()
                .title(request.title())
                .description(request.description())
                .difficulty(request.difficulty())
                .distanceKm(request.distanceKm())
                .startLocation(request.startLocation())
                .creator(creator)
                .build();

        return toResponse(routeRepository.save(route));
    }

    public void delete(Long id) {
        if (!routeRepository.existsById(id)) {
            throw new IllegalArgumentException("Route not found");
        }
        routeRepository.deleteById(id);
    }

    private RouteResponse toResponse(Route route) {
        return new RouteResponse(
                route.getId(),
                route.getTitle(),
                route.getDescription(),
                route.getDifficulty(),
                route.getDistanceKm(),
                route.getStartLocation(),
                route.getCreator().getId(),
                route.getCreator().getDisplayUsername(),
                route.getCreatedAt()
        );
    }
}
