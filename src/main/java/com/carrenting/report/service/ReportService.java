package com.carrenting.report.service;

import com.carrenting.report.dto.Reservation;
import com.carrenting.report.feign.ReservationClient;
import com.carrenting.report.ports.in.ReportManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportService implements ReportManager {

    private final ReservationClient reservationClient;


    @Autowired
    ReportService(ReservationClient reservationClient){
        this.reservationClient=reservationClient;
    }



    @Override
    public String createReservationCsvReport(List<Reservation> reservations) {
        if (reservations == null || reservations.isEmpty()) {
            return "";
        }
        String header = "ReservationID,StartDate,EndDate,CustomerID,CarID";
        String csvBody = reservations.stream()
                .map(reservation -> reservation.getReservationID() + "," +
                        reservation.getStartDate() + "," +
                        reservation.getEndDate() + "," +
                        reservation.getCustomerID() + "," +
                        reservation.getCarID())
                .collect(Collectors.joining("\n"));
        return header + "\n" + csvBody;
    }

    public List<Reservation> getAllReservations() {
        return reservationClient.getAllReservations();
    }

}
