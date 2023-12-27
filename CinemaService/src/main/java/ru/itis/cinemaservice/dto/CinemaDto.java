package ru.itis.cinemaservice.dto;

import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.cinemaservice.models.Cinema;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CinemaDto {
  private String name;
  private String city;

  public static CinemaDto from(Cinema cinema) {
    return CinemaDto.builder()
        .name(cinema.getName())
        .city(cinema.getCity())
        .build();
  }

  public static List<CinemaDto> from(List<Cinema> cinemas) {
    return cinemas.stream().map(CinemaDto::from).collect(Collectors.toList());
  }
}
