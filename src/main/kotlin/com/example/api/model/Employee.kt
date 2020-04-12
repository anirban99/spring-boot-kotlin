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
data class Employee (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,
        @Column(name = "first_name", nullable = false)
        var firstName: String = "",
        @Column(name = "middle_name", nullable = true)
        var middleName: String? = "",
        @Column(name = "last_name", nullable = false)
        var lastName: String = "",
        @Column(name = "email_address", nullable = false)
        var emailId: String = ""
)
