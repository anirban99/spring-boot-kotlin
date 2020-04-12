package com.example.api.controller

import com.example.api.model.Employee
import com.example.api.repository.EmployeeRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid


@RestController
@RequestMapping("/api/v1")
class EmployeeController(private val employeeRepository: EmployeeRepository) {

    @GetMapping("/employees")
    fun getAllEmployees(): List<Employee> = employeeRepository.findAll()

    @GetMapping("/employees/{id}")
    fun getEmployeesById(@PathVariable("id") employeeId: Long): ResponseEntity<Employee> {
        return employeeRepository.findById(employeeId).map { employee ->
            ResponseEntity.ok(employee)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PostMapping("/employees")
    fun createEmployee(@Valid @RequestBody employee: Employee): Employee = employeeRepository.save(employee)

    @PutMapping("/employees/{id}")
    fun updateEmployeeById(@PathVariable("id") employeeId: Long, @Valid @RequestBody employeeDetails: Employee) : ResponseEntity<Employee> {
        return employeeRepository.findById(employeeId).map {
            val updatedEmployeeDetails : Employee = it.copy(
                    firstName = employeeDetails.firstName,
                    lastName = employeeDetails.lastName,
                    emailId = employeeDetails.emailId
            )
            ResponseEntity.ok().body(employeeRepository.save(updatedEmployeeDetails))
        }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/employees/{id}")
    fun deleteEmployeesById(@PathVariable("id") employeeId: Long): ResponseEntity<Employee> {
        return employeeRepository.findById(employeeId).map {employee ->
            employeeRepository.delete(employee)
            ResponseEntity.ok(employee)
        }.orElse(ResponseEntity.notFound().build())
    }
}
