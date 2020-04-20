package com.example.api.controller

import com.example.api.model.EmployeeEntity
import com.example.api.repository.EmployeeRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/api/v1")
class EmployeeController(private val employeeRepository: EmployeeRepository) {

    @GetMapping("/employees")
    fun getAllEmployees(): List<EmployeeEntity> = employeeRepository.findAll()

    @GetMapping("/employees/{id}")
    fun getEmployeesById(@PathVariable("id") employeeId: Long): ResponseEntity<EmployeeEntity> {
        return employeeRepository.findById(employeeId).map { employee ->
            ResponseEntity.ok(employee)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PostMapping("/employees")
    fun createEmployee(@Valid @RequestBody employeeEntity: EmployeeEntity): EmployeeEntity = employeeRepository.save(employeeEntity)

    @PutMapping("/employees/{id}")
    fun updateEmployeeById(@PathVariable("id") employeeId: Long, @Valid @RequestBody employeeEntityDetails: EmployeeEntity) : ResponseEntity<EmployeeEntity> {
        return employeeRepository.findById(employeeId).map {
            val updatedEmployeeEntityDetails : EmployeeEntity = it.copy(
                    firstName = employeeEntityDetails.firstName,
                    lastName = employeeEntityDetails.lastName,
                    emailId = employeeEntityDetails.emailId
            )
            ResponseEntity.ok().body(employeeRepository.save(updatedEmployeeEntityDetails))
        }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/employees/{id}")
    fun deleteEmployeesById(@PathVariable("id") employeeId: Long): ResponseEntity<EmployeeEntity> {
        return employeeRepository.findById(employeeId).map {employee ->
            employeeRepository.delete(employee)
            ResponseEntity.ok(employee)
        }.orElse(ResponseEntity.notFound().build())
    }
}
