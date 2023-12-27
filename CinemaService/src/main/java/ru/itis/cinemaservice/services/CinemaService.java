package ru.itis.cinemaservice.services;

import ru.itis.cinemaservice.dto.CinemaPage;

public interface CinemaService {
  CinemaPage getCinemasByCity(String city, Integer page);
}
