package com.carrenting.report.apdapter;

import com.carrenting.report.dto.CarDto;
import com.carrenting.report.dto.CustomerDto;
import com.carrenting.report.dto.MaintenanceDto;
import com.carrenting.report.dto.ReservationDto;
import com.carrenting.report.service.ReportService;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/export")
public class ExportController {

    private ReportService reportService;


    //http://localhost:8086/api/export/csv?requestType=Reservation


    @GetMapping(value = "/csv", produces = MediaType.TEXT_PLAIN_VALUE)
    public String exportAsCsv(String requestType) {

        switch (requestType){

            case "Reservation":
                List<ReservationDto> reservationDtos = reportService.getAllReservations();
                return reportService.createCsvReservationReport(reservationDtos);

            case "Maintenance":
                List<MaintenanceDto> maintenanceDtos = reportService.getAllMaintenances();
                return reportService.createCsvMaintenanceReport(maintenanceDtos);

            case "Customer":
                List<CustomerDto> customerDtos = reportService.getAllCustomers();
                return reportService.createCsvCustomerReport(customerDtos);

            case "Car":
                List<CarDto> carDtos = reportService.getAllCars();
                return  reportService.createCsvCarReport(carDtos);

            default:
                System.out.println("Unbekannte Art");
                return "";

        }





    }
}
