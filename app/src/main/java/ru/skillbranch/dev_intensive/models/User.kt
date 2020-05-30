package ru.skillbranch.dev_intensive.models

import ru.skillbranch.dev_intensive.utils.Utils
import java.util.*

data class User (
    val id:String,
    var firstName:String?,
    var lastName:String?,
    var avatar:String?,
    var rating:Int = 0,
    var respect:Int = 0,
    val lastVisit:Date? = null,
    val isOnline:Boolean = false

) {
    constructor(id:String, firstName:String?, lastName:String?) : this(
        id, firstName, lastName, null)
    constructor(id:String) : this (id, "John", "Doe")

    init {
        println("It's Alive!!! \n${if(lastName === "Doe") "His name id $firstName $lastName" 
                                    else "And his name is $firstName $lastName!!!"}\n")
    }
    companion object Factory {
        private var lastid :Int = -1
        fun makeUser(fullName:String?) : User {
            lastid++

            val (firstName, lastName) = Utils.parselFullName(fullName)

            return User(id= "$lastid", firstName = firstName, lastName = lastName)
        }
    }
}
