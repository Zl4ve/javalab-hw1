package ru.itis.cinemaservice.controllers;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.cinemaservice.controllers.api.CinemaApi;
import ru.itis.cinemaservice.dto.CinemaPage;
import ru.itis.cinemaservice.services.CinemaService;

@RestController
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CinemaController implements CinemaApi {

  CinemaService cinemaService;

  @Override
  public ResponseEntity<CinemaPage> getCinemasByCity(String city, Integer page) {
    CinemaPage cinemaPage = cinemaService.getCinemasByCity(city, page);

    if (cinemaPage.getCinemas().isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok(cinemaPage);
  }
}
