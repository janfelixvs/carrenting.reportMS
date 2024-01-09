package com.carrenting.report.ports.in;

import com.carrenting.report.dto.CarDto;
import com.carrenting.report.dto.CustomerDto;
import com.carrenting.report.dto.MaintenanceDto;
import com.carrenting.report.dto.ReservationDto;
import java.util.List;

public interface ReportManager {


    String createCsvReservationReport(List<ReservationDto> reservations);
    String createCsvMaintenanceReport(List<MaintenanceDto> maintenanceDtos);
    String createCsvCustomerReport(List<CustomerDto> customerDtos);
    String createCsvCarReport(List<CarDto> carDtos);
}
