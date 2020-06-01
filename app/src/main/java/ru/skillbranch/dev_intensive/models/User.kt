package ru.skillbranch.dev_intensive.models

import ru.skillbranch.dev_intensive.utils.Utils
import java.util.*

data class User (
    val id:String?,
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
    class  Builder{
        var id: String? = null
        var firstName: String? = null
        var lastName: String? = null
        var avatar:String? = null
        var rating:Int = 0
        var respect:Int = 0
        var lastVisit:Date? = null
        var isOnline:Boolean = false

        fun id(value: String) = apply {this.id = value}
        fun firstName (value: String) = apply {this.firstName = value}
        fun lastName (value: String) = apply {this.lastName = value}
        fun avatar (value: String) = apply {this.avatar = value}
        fun rating (value: Int) = apply {this.rating = value}
        fun respect (value: Int) = apply {this.respect = value}
        fun lastVisit (value: Date) = apply {this.lastVisit = value}
        fun isOnline (value: Boolean) = apply {this.isOnline = value}
        fun build () = User(this.id, this.firstName, this.lastName, this.avatar, this.rating,
            this.respect, this.lastVisit, this.isOnline)

    }
}
