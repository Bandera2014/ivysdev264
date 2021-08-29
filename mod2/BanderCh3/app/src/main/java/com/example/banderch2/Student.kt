package com.example.banderch2

import java.sql.DriverManager.println

open class Student(){
    var firstName:String?=null
    var lastName:String?=null
    var streetAddress:String?=null
    var city:String?=null
    var state:String?=null
    var zip:Int?=null
    var gpa:Double?=null
    var major:String?=null

    constructor(firstName: String?,lastName: String?,streetAddress: String?,city: String?,
                state: String?,zip:Int?,gpa:Double?,major: String?):this() {
        this.firstName = firstName
        this.lastName = lastName
        this.streetAddress = streetAddress
        this.city = city
        this.state = state
        this.zip = zip
        this.gpa = gpa
        this.major = major

        println("hi")
    }

    constructor(firstName: String?,lastName: String?,streetAddress: String?,city: String?,
        state: String?,zip: Int?,major: String?):this() {
        this.firstName = firstName
        this.lastName = lastName
        this.streetAddress = streetAddress
        this.city = city
        this.state = state
        this.zip = zip
        this.major = major
    }


    override fun toString(): String {
        return "Student(firstName=$firstName, lastName=$lastName, streetAddress=$streetAddress, city=$city, state=$state, zip=$zip, gpa=$gpa, major=$major)"
    }


}

