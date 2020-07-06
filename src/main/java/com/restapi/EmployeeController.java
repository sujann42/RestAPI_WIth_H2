package com.restapi;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployRepository employRepository;

    public EmployeeController(EmployRepository employRepository) {
        this.employRepository = employRepository;
    }

    //Get All Employees
    @GetMapping("/employees")
    List<Employee> gelAll() {
        return employRepository.findAll();
    }

    //Get 1 employee by ID
    @GetMapping("/employees/{id}")
    Employee getEmpById(@PathVariable Long id) {
        return employRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    //Post Employee
    @PostMapping("/employees")
    Employee postEmployee(@RequestBody Employee newEmployee) {
        return employRepository.save(newEmployee);
    }

    //Update Employee
    @PutMapping("/employees/{id}")
    Employee updateEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
        return employRepository.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setRole(newEmployee.getRole());
                    return employRepository.save(employee);
                })
                .orElseGet(() ->{
                    newEmployee.setId(id);
                    return employRepository.save(newEmployee);
                });
    }

    //Delete Employee
    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id) {
        employRepository.deleteById(id);
    }

}
