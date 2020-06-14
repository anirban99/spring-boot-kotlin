package com.example.api.utils.faker

import com.example.api.repository.model.EmployeeEntity
import com.example.api.service.model.Employee
//import com.github.javafaker.Faker


class EmployeeFaker {
    companion object {
        fun fakeEmployee(): Employee {
//            val javaFaker = Faker()
            return Employee(
                    id = Math.random().toLong(),
                    firstName = "Brock",
                    middleName = "",
                    lastName = "Lesnar",
                    emailId = "Brock.Lesnar" + Math.random() + "@gmail.com"
            )
        }

        fun fakeEmployeeEntity(): EmployeeEntity {
//            val javaFaker = Faker()
            return EmployeeEntity(
                    id = Math.random().toLong(),
                    firstName = "Brock",
                    middleName = "",
                    lastName = "Lesnar",
                    emailId = "Brock.Lesnar" + Math.random() + "@gmail.com"
            )
        }
    }
}
