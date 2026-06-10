package com.angelorden.bimu.route;

import com.angelorden.bimu.user.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/routes")
@RequiredArgsConstructor
public class RouteController {

    private final RouteService routeService;

    @GetMapping
    public List<RouteResponse> findAll() {
        return routeService.findAll();
    }

    @GetMapping("/{id}")
    public RouteResponse findById(@PathVariable Long id) {
        return routeService.findById(id);
    }

    @PostMapping
    public RouteResponse create(
            @Valid @RequestBody CreateRouteRequest request,
            @AuthenticationPrincipal User creator
    ) {
        return routeService.create(request, creator);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        routeService.delete(id);
    }
}
