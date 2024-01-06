package com.carrenting.report.ports.in;

import com.carrenting.report.dto.Reservation;
import java.util.List;

public interface ReportManager {


    String createReservationCsvReport(List<Reservation> reservations);
}
