package ru.itis.clientservice.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ru.itis.clientservice.dto.CinemaDto;

import java.util.List;

@FeignClient(name = "cinema-service", url = "${feign.cinema-service.url}")
public interface CinemaService {
    @GetMapping(value = "/v1/api/cinemas", consumes = MediaType.APPLICATION_JSON_VALUE)
    List<CinemaDto> getCinemas(
            @RequestParam("city") String city,
            @RequestParam("api-key") String apiKey);

}
