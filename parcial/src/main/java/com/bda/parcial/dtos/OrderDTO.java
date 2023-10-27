package com.bda.parcial.dtos;

import com.bda.parcial.models.Customer;
import com.bda.parcial.models.Employee;
import com.bda.parcial.models.Shipper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private long orderID;
    private Customer customerId;
    private Employee employeeId;
    private Date orderDate;
    private LocalDateTime requiredDate;
    private LocalDateTime shippedDate;
    private Shipper shipVia;
    private double freight;
    private String shipName;
    private String shipAddress;
    private String shipCity;
    private String shipRegion;
    private String shipPostalCode;
    private String shipCountry;

}
