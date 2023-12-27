package ru.itis.cinemaservice.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PageUtils {
  public static int DEFAULT_PAGE_SIZE;

  @Value("${cinemas.page.size}")
  public void setDefaultPageSize(int defaultPageSize) {
    DEFAULT_PAGE_SIZE = defaultPageSize;
  }
}
