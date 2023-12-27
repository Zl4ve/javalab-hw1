package ru.itis.clientservice.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.clientservice.dto.HotelDto;

import java.util.List;

@FeignClient(name = "hotel-service", url = "${feign.hotel-service.url}")
public interface HotelService {
    @GetMapping(value = "/v1/api/hotels", consumes = MediaType.APPLICATION_JSON_VALUE)
    List<HotelDto> getHotels(
            @RequestParam("city") String city,
            @RequestParam("api-key") String apiKey);

}
