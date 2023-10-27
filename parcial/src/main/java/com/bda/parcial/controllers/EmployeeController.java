package com.bda.parcial.controllers;

import com.bda.parcial.models.Employee;
import com.bda.parcial.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee") // http:/localhost:8080/api/employee
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    @GetMapping
    public ResponseEntity<List<Employee>> getAll(){
        List<Employee> values = this.employeeService.getAll();
        return ResponseEntity.ok(values);
    }

    @PostMapping
    public ResponseEntity<Employee> add(@RequestBody Employee employee){
        Employee e = this.employeeService.add(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(e);
    }
}
