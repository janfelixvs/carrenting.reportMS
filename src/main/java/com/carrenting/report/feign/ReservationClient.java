package com.carrenting.report.feign;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import com.carrenting.report.dto.Reservation;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

@FeignClient(name = "reservation-service", url = "http://localhost:8083")
public interface ReservationClient {
    @GetMapping("api/reservation")
    List<Reservation> getAllReservations();

}
