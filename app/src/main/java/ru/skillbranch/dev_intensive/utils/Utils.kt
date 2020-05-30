package ru.skillbranch.dev_intensive.utils

object Utils {
    fun parselFullName (fullName:String?):Pair<String?, String?>{

        val parts : List<String>? = fullName?.split(" ")

        var firstName = parts?.getOrNull(0)
        var lastName = parts?.getOrNull(1)
        return Pair(firstName, lastName)
    }
}