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
        @Column(name = "first_name", nullable = true)
        var firstName: String? = null,
        @get:Column(name = "last_name", nullable = true)  //@get annotate Java getter
        var lastName: String? = null,
        @Column(name = "email_address", nullable = true)
        var emailId: String? = null
)
