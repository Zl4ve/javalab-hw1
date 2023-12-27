package ru.itis.hotelservice.controllers;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.hotelservice.controllers.api.HotelApi;
import ru.itis.hotelservice.dto.HotelPage;
import ru.itis.hotelservice.services.HotelService;

@RestController
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class HotelController implements HotelApi {

  HotelService hotelService;

  @Override
  public ResponseEntity<HotelPage> getHotelsByCity(String city, Integer page) {

    HotelPage hotelPage = hotelService.getHotelsByCity(city, page);

    if (hotelPage.getHotels().isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok(hotelService.getHotelsByCity(city, page));
  }
}
