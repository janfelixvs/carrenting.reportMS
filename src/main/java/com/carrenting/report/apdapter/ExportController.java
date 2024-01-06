package com.carrenting.report.apdapter;

import com.carrenting.report.dto.Reservation;
import com.carrenting.report.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/export")
public class ExportController {

    @Autowired
    private ReportService reportService;

    @GetMapping(value = "/csv", produces = MediaType.TEXT_PLAIN_VALUE)
    public String exportReservationsAsCsv() {
        List<Reservation> reservations = reportService.getAllReservations();
        return reportService.createReservationCsvReport(reservations);
    }
}
