package com.example.api.service

import com.example.api.model.EmployeeEntity
import com.example.api.repository.EmployeeRepository
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class EmployeeService(private val employeeRepository: EmployeeRepository) {

    fun getAllEmployees(): List<EmployeeEntity> = employeeRepository.findAll()

    fun getEmployeesById(employeeId: Long): Optional<EmployeeEntity> = employeeRepository.findById(employeeId)

    fun createEmployee(employeeEntity: EmployeeEntity): EmployeeEntity = employeeRepository.save(employeeEntity)

    fun updateEmployeeById(employeeId: Long, employeeEntityDetails: EmployeeEntity): Optional<EmployeeEntity>? {
        return employeeRepository.findById(employeeId).map {
            val updatedEmployeeEntityDetails : EmployeeEntity = it.copy(
                    firstName = employeeEntityDetails.firstName,
                    lastName = employeeEntityDetails.lastName,
                    emailId = employeeEntityDetails.emailId
            )
            employeeRepository.save(updatedEmployeeEntityDetails)
        }
    }

    fun deleteEmployeesById(employeeId: Long): Optional<Unit>? {
        return employeeRepository.findById(employeeId).map {employee ->
            employeeRepository.delete(employee)
        }
    }
}