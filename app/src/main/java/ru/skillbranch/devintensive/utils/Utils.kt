package ru.skillbranch.devintensive.utils

object Utils {
    val mapTranslit = mapOf(
        "а" to "a",
        "б" to "b",
        "в" to "v",
        "г" to "g",
        "д" to "d",
        "е" to "e",
        "ё" to "e",
        "ж" to "zh",
        "з" to "z",
        "и" to "i",
        "й" to "i",
        "к" to "k",
        "л" to "l",
        "м" to "m",
        "н" to "n",
        "о" to "o",
        "п" to "p",
        "р" to "r",
        "с" to "s",
        "т" to "t",
        "у" to "u",
        "ф" to "f",
        "х" to "h",
        "ц" to "c",
        "ч" to "ch",
        "ш" to "sh",
        "щ" to "sh'",
        "ъ" to "",
        "ы" to "i",
        "ь" to "",
        "э" to "e",
        "ю" to "yu",
        "я" to "ya"
    )
    fun parseFullName (fullName:String?):Pair<String?, String?>{

        if (fullName != null && !fullName.isEmpty() ) {

            val parts: List<String>? = fullName.split(" ")

            var firstName = parts?.getOrNull(0)
            var lastName = parts?.getOrNull(1)

            if (lastName=="")  lastName = null

            return Pair(firstName, lastName)
        }
        return Pair(null, null)
    }

    fun transliteration(payload: String, divider:String = " "): String {
        var translit: String = ""

        for (char in payload){
            translit+=when{
                mapTranslit.containsKey("$char") -> mapTranslit.getValue("$char")
                char == ' ' -> divider
                else -> char
            }
        }
        return translit
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        val letterfirstName = GetFirstLetter(firstName)
        val letterlastName = GetFirstLetter(lastName)

        return if ((letterfirstName.isEmpty()) && letterlastName.isEmpty()) null
        else "$letterfirstName$letterlastName"

    }
    fun GetFirstLetter(s: String?): String {
        val symbol: Char? = s?.getOrNull(0)?.toUpperCase()
        if ((symbol === null) || symbol === ' ') return ""
        else return "$symbol"
    }
}


