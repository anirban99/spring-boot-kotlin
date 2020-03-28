package com.example.api.repository

import com.example.api.model.Employee
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Repository


@PreAuthorize("hasRole('ROLE_USER')")
@Repository
interface EmployeeRepository : JpaRepository<Employee, Long> {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    fun save(employee: Employee): Employee

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    fun delete(id: Long)
}