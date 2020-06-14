package com.example.api.service

import com.example.api.repository.EmployeeRepository
import com.example.api.utils.faker.EmployeeFaker
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import java.util.*

class EmployeeServiceUnitTest {

    private val employeeRepository: EmployeeRepository = mock { }
    private val classUnderTest = EmployeeService(employeeRepository)
    private val id = Math.random().toLong()

    @Test
    fun `given employees, when all employees are requested, then all employees are returned`() {
        val employeeList = listOf(
                EmployeeFaker.fakeEmployeeEntity(),
                EmployeeFaker.fakeEmployeeEntity(),
                EmployeeFaker.fakeEmployeeEntity(),
                EmployeeFaker.fakeEmployeeEntity()
        )

        `when`(employeeRepository.findAll()).doReturn(employeeList)
        assertEquals(4, classUnderTest.getAllEmployees().size)
    }

    @Test
    fun `given employees, when employees are requested by id, then one employee is returned`() {
        `when`(employeeRepository.findById(id)).doReturn(
                Optional.of(EmployeeFaker.fakeEmployeeEntity().copy(id = id))
        )
        val result = classUnderTest.getEmployeesById(id)
        println("result $result")
        assertEquals(id, result.id)
    }

//    @Test
//    fun `when employee is created, then it returns the new employee details`() {
//        `when`(employeeRepository.save(EmployeeFaker.fakeEmployeeEntity().copy(id = id))).doReturn(
//                EmployeeFaker.fakeEmployeeEntity().copy(id = id)
//        )
//
//        val result = classUnderTest.createEmployee(EmployeeFaker.fakeEmployee())
//        println("result $result")
//        assertEquals("Lesnar", result.lastName)
//        assertEquals("Brock", result.firstName)
//    }
//
//    @Test
//    fun `when employee is updated, then it returns the updated employee details`() {
//
//    }
//
//    @Test
//    fun `when employee is deleted, then it returns the deleted employee details`() {
//
//    }
}
