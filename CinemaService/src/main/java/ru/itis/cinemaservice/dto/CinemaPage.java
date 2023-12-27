package ru.itis.cinemaservice.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CinemaPage {

  private List<CinemaDto> cinemas;

  private Integer totalPages;
}
