package com.carrenting.report.service;

import com.carrenting.report.dto.CarDto;
import com.carrenting.report.dto.CustomerDto;
import com.carrenting.report.dto.MaintenanceDto;
import com.carrenting.report.dto.ReservationDto;
import com.carrenting.report.feign.EmployeeClient;
import com.carrenting.report.ports.in.ReportManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportService implements ReportManager {

    private final EmployeeClient reservationClient;


    @Autowired
    ReportService(EmployeeClient reservationClient){
        this.reservationClient=reservationClient;
    }



    @Override
    public String createCsvReservationReport(List<ReservationDto> reservations) {
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

    @Override
    public String createCsvMaintenanceReport(List<MaintenanceDto> maintenances) {
        if (maintenances == null || maintenances.isEmpty()) {
            return "";
        }
        String header = "MaintenanceID,CarID,StartDate,EndDate,Status";
        String csvBody = maintenances.stream()
                .map(maintenance -> maintenance.getMaintenanceID() + "," +
                        maintenance.getCarID() + "," +
                        maintenance.getStartDate() + "," +
                        maintenance.getEndDate() + "," +
                        maintenance.getStatus())
                .collect(Collectors.joining("\n"));
        return header + "\n" + csvBody;
    }

    @Override
    public String createCsvCustomerReport(List<CustomerDto> customerDtos) {
        if (customerDtos == null || customerDtos.isEmpty()) {
            return "";
        }
        String header = "CustomerID,FirstName,LastName,Email,Password";
        String csvBody = customerDtos.stream()
                .map(customer -> customer.getCustomerId() + "," +
                        customer.getFirstName() + "," +
                        customer.getLastName() + "," +
                        customer.getEmail() + "," +
                        customer.getPassword())
                .collect(Collectors.joining("\n"));
        return header + "\n" + csvBody;
    }

    @Override
    public String createCsvCarReport(List<CarDto> carDtos) {
        if (carDtos == null || carDtos.isEmpty()) {
            return "";
        }
        String header = "CarID,LicensePlate,Mileage,Brand,Model";
        String csvBody = carDtos.stream()
                .map(car -> car.getCarID() + "," +
                        car.getLicensePlate() + "," +
                        car.getMileage() + "," +
                        car.getBrand() + "," +
                        car.getModel())
                .collect(Collectors.joining("\n"));
        return header + "\n" + csvBody;
    }








    public List<ReservationDto> getAllReservations() {
        return reservationClient.getAllReservations();
    }
    public List<CarDto> getAllCars() {return reservationClient.getAllCars();
    }
    public List<CustomerDto> getAllCustomers(){return  reservationClient.getAllCustomers();}
    public List<MaintenanceDto> getAllMaintenances(){return  reservationClient.getAllMaintenances();}


}
