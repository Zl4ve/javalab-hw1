package ru.itis.hotelservice.services.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.itis.hotelservice.dto.HotelDto;
import ru.itis.hotelservice.dto.HotelPage;
import ru.itis.hotelservice.models.Hotel;
import ru.itis.hotelservice.repositories.HotelRepository;
import ru.itis.hotelservice.services.HotelService;
import ru.itis.hotelservice.utils.PageUtils;

import static ru.itis.hotelservice.dto.HotelDto.from;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
public class HotelServiceImpl implements HotelService {

  HotelRepository hotelRepository;

  @Override
  public HotelPage getHotelsByCity(String city, Integer page) {
    PageRequest request = PageRequest.of(page, PageUtils.DEFAULT_PAGE_SIZE, Sort.by("id"));
    Page<Hotel> hotels = hotelRepository.findAllByCity(city, request);

    return HotelPage.builder()
        .hotels(HotelDto.from(hotels.getContent()))
        .totalPages(hotels.getTotalPages())
        .build();
  }
}
