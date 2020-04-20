package com.example.api.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

/** the employee domain entity **/
@Entity
@Table(name = "employees")
data class EmployeeEntity (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,
        @Column(name = "first_name", nullable = false)
        val firstName: String = "",
        @Column(name = "middle_name", nullable = true)
        val middleName: String? = null,
        @Column(name = "last_name", nullable = false)
        val lastName: String = "",
        @Column(name = "email_address", nullable = false)
        val emailId: String = ""
)
