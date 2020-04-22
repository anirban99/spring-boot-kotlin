package com.example.api.controller

import com.example.api.model.EmployeeEntity
import com.example.api.repository.EmployeeRepository
import com.example.api.service.EmployeeService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid


@RestController
@RequestMapping("/api/v1")
class EmployeeController(private val employeeService: EmployeeService) {

    @GetMapping("/employees")
    fun getAllEmployees(): List<EmployeeEntity> = employeeService.getAllEmployees()

    @GetMapping("/employees/{id}")
    fun getEmployeesById(@PathVariable("id") employeeId: Long): ResponseEntity<Optional<EmployeeEntity>> {
//        return employeeRepository.findById(employeeId).map { employee ->
//            ResponseEntity.ok(employee)
//        }.orElse(ResponseEntity.notFound().build())
        return ResponseEntity.ok().body(employeeService.getEmployeesById(employeeId))
    }

    @PostMapping("/employees")
    fun createEmployee(@Valid @RequestBody employeeEntity: EmployeeEntity): EmployeeEntity = employeeService.createEmployee(employeeEntity)

    @PutMapping("/employees/{id}")
    fun updateEmployeeById(@PathVariable("id") employeeId: Long, @Valid @RequestBody employeeEntityDetails: EmployeeEntity) : ResponseEntity<Optional<EmployeeEntity>> {
//        return employeeRepository.findById(employeeId).map {
//            val updatedEmployeeEntityDetails : EmployeeEntity = it.copy(
//                    firstName = employeeEntityDetails.firstName,
//                    lastName = employeeEntityDetails.lastName,
//                    emailId = employeeEntityDetails.emailId
//            )
//            ResponseEntity.ok().body(employeeRepository.save(updatedEmployeeEntityDetails))
//        }.orElse(ResponseEntity.notFound().build())
        return ResponseEntity.ok().body(employeeService.updateEmployeeById(employeeId, employeeEntityDetails))
    }

    @DeleteMapping("/employees/{id}")
    fun deleteEmployeesById(@PathVariable("id") employeeId: Long): ResponseEntity<Optional<Unit>?>? {
//        return employeeRepository.findById(employeeId).map {employee ->
//            employeeRepository.delete(employee)
//            ResponseEntity.ok(employee)
//        }.orElse(ResponseEntity.notFound().build())
        return employeeService.deleteEmployeesById(employeeId)?.let { ResponseEntity.ok(it) }
    }
}
