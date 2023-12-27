package ru.itis.hotelservice.services;

import ru.itis.hotelservice.dto.HotelPage;

public interface HotelService {
  HotelPage getHotelsByCity(String city, Integer page);
}
