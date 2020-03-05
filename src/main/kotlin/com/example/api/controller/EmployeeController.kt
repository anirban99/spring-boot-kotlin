package com.example.api.controller

import com.example.api.model.Employee
import com.example.api.repository.EmployeeRepository
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1")
class EmployeeController(private val employeeRepository: EmployeeRepository) {

    @GetMapping("/employees")
    fun getAllEmployees(): List<Employee> = employeeRepository.findAll()

    @PostMapping("/employees")
    fun createEmployee(@Valid @RequestBody employee: Employee): Employee = employeeRepository.save(employee)
}
