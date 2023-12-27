package ru.itis.hotelservice.controllers.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.hotelservice.dto.HotelPage;

@Tags(value =
  @Tag(name = "Hotel")
)
@RequestMapping("/api/hotels")
public interface HotelApi {

  @Operation(summary = "Получение отелей в городе", description = "Доступно всем пользователям")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Запрос обработан успешно",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = HotelPage.class))
          }),
      @ApiResponse(responseCode = "404", description = "В городе нет отелей",
          content = {
              @Content(mediaType = "application/json")
          })
  })
  ResponseEntity<HotelPage> getHotelsByCity(@RequestParam("city") String city,
      @RequestParam("page") Integer page);
}
