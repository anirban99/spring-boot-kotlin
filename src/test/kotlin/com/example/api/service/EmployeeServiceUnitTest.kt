package com.example.api.service

import com.example.api.repository.EmployeeRepository
import com.example.api.utils.faker.EmployeeFaker
import com.nhaarman.mockitokotlin2.doReturn
import org.junit.jupiter.api.BeforeAll
import com.nhaarman.mockitokotlin2.mock
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.mockito.Mockito.`when`

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EmployeeServiceUnitTest {
    private lateinit var employeeRepository: EmployeeRepository
    private lateinit var classUnderTest: EmployeeService

    private val id = Math.random().toLong()
    private val employeeList = listOf(
            EmployeeFaker.fakeEmployeeEntity(),
            EmployeeFaker.fakeEmployeeEntity(),
            EmployeeFaker.fakeEmployeeEntity(),
            EmployeeFaker.fakeEmployeeEntity()
    )

    @BeforeAll
    fun setUp() {
        employeeRepository = mock {}

        classUnderTest = EmployeeService(
                employeeRepository
        )
    }

    @Test
    fun `given employees, when all employees are requested, then all employees are returned`() {
        `when`(employeeRepository.findAll()).doReturn(employeeList)
        assertEquals(4, classUnderTest.getAllEmployees().size)
    }

    @Test
    fun `given employees, when employees are requested by id, then one employee is returned`() {
        `when`(employeeRepository.findByIdOrNull(id)).doReturn(
                EmployeeFaker.fakeEmployeeEntity().copy(id = id)
        )
        val result = classUnderTest.getEmployeesById(id)
        assertEquals(id, result.id)
    }
}