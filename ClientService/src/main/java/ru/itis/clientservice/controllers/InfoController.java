package ru.itis.clientservice.controllers;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.clientservice.services.CinemaService;
import ru.itis.clientservice.services.HotelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.clientservice.dto.CinemaDto;
import ru.itis.clientservice.dto.HotelDto;
import ru.itis.clientservice.dto.InfoDto;

import java.util.List;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@RestController
public class InfoController {
    HotelService hotelsService;
    CinemaService cinemasService;

    @GetMapping("/info")
    public ResponseEntity<InfoDto> getInfo(@RequestParam("city") String city) {
        List<HotelDto> hotels = hotelsService.getHotels(city, "123");
        List<CinemaDto> cinemas = cinemasService.getCinemas(city, "123");

        return ResponseEntity.ok(InfoDto.builder()
                .cinemas(cinemas)
                .hotels(hotels)
                .build());
    }
}
