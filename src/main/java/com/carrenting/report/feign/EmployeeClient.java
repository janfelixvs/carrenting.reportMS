package com.carrenting.report.feign;

import com.carrenting.report.dto.CarDto;
import com.carrenting.report.dto.CustomerDto;
import com.carrenting.report.dto.MaintenanceDto;
import org.springframework.web.bind.annotation.GetMapping;
import com.carrenting.report.dto.ReservationDto;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

@FeignClient(name = "employeeClient", url = "http://employee:8081")
public interface EmployeeClient {



    //Reservation
    @GetMapping("/api/employee/reservation")
    List<ReservationDto> getAllReservations();


    //Maintenance
    @GetMapping("/api/employee/maintenance/all")
    List<MaintenanceDto> getAllMaintenances();

    //Customer
    @GetMapping("/api/employee/customer")
    List<CustomerDto> getAllCustomers();

    //Car
    @GetMapping("/api/employee/car")
    List<CarDto> getAllCars();


}
