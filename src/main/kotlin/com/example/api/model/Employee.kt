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

// if you give default values to all the fields - empty constructor is generated automatically by Kotlin.
// on the JVM, if all of the parameters of the primary constructor have default values, the compiler will generate an additional parameter less constructor which will use the default values.
// data classes also derives the implementation of standard methods like equals(), hashCode(), toString(), copy() and componentN() from the properties declared in the data class’s primary constructor.
// the compiler automatically generates a default getter and setter for all the mutable properties(var), and a getter only for all the read-only properties(val) of the data class.
// make values nullable by adding ? and then you can assign null.
// The language's type system differentiates between nullable and non-nullable types and every class can be used in both versions. By default, a reference of type String cannot hold null, whereas String? allows it.
// declare a variable with nullable String type, it's OK to assign `null` to it    https://kotlinexpertise.com/kotlin-nullability-features/
// var b: String? = "possiblyNull"
// https://www.baeldung.com/kotlin-jpa


//Every Data Class in Kotlin needs to fulfill the following requirements -  https://kotlinexpertise.com/kotlinquickreference/
//
//The primary constructor must have at least one parameter
//All the parameters declared in the primary constructor need to be marked as val or var.
//Data classes cannot be abstract, open, sealed or inner.