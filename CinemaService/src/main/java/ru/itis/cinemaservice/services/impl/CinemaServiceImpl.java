package ru.itis.cinemaservice.services.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.itis.cinemaservice.dto.CinemaPage;
import ru.itis.cinemaservice.models.Cinema;
import ru.itis.cinemaservice.repositories.CinemaRepository;
import ru.itis.cinemaservice.services.CinemaService;

import static ru.itis.cinemaservice.dto.CinemaDto.from;
import static ru.itis.cinemaservice.utils.PageUtils.DEFAULT_PAGE_SIZE;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
public class CinemaServiceImpl implements CinemaService {

  CinemaRepository cinemaRepository;

  @Override
  public CinemaPage getCinemasByCity(String city, Integer page) {
    PageRequest request = PageRequest.of(page, DEFAULT_PAGE_SIZE, Sort.by("id"));
    Page<Cinema> cinemas = cinemaRepository.findAllByCity(city, request);

    return CinemaPage.builder()
        .cinemas(from(cinemas.getContent()))
        .totalPages(cinemas.getTotalPages())
        .build();
  }
}
