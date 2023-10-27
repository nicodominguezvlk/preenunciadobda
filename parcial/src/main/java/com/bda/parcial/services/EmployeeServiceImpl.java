package com.bda.parcial.services;

import com.bda.parcial.models.Employee;
import com.bda.parcial.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee add(Employee entity) {
        return this.employeeRepository.save(entity);
    }

    @Override
    public Employee update(Employee entity) {
        return this.employeeRepository.save(entity);
    }

    @Override
    public Employee delete(Long id) {
        Employee employee = this.employeeRepository.getById(id);
        this.employeeRepository.delete(employee);
        return employee;
    }

    @Override
    public Employee getById(Long id) {
        return this.employeeRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Employee> getAll() {
        return this.employeeRepository.findAll();
    }
}
