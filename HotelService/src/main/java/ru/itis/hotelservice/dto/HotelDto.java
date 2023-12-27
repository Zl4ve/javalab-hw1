package ru.itis.hotelservice.dto;

import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.hotelservice.models.Hotel;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HotelDto {
  private String name;
  private String city;

  public static HotelDto from(Hotel hotel) {
    return HotelDto.builder()
        .name(hotel.getName())
        .city(hotel.getCity())
        .build();
  }

  public static List<HotelDto> from(List<Hotel> hotels) {
    return hotels.stream().map(HotelDto::from).collect(Collectors.toList());
  }
}
