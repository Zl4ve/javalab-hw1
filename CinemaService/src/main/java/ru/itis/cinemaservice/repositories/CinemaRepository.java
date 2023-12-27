package ru.itis.cinemaservice.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.cinemaservice.models.Cinema;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {
    Page<Cinema> findAllByCity(String city, PageRequest request);
}
