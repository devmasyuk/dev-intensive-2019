package ru.skillbranch.devintensive.extensions

fun String.truncate(value: Int=16): String{
    val s: String = this
    return when{
        s.trim().length <= value -> s.trim()
        s.trim().length > value -> "${s.take(value).trim()}..."
        else -> ""
    }
}
fun String.stripHtml(): String{
    return this.replace(Regex("&.+?;|<.+?>")," ")?.replace(Regex(" +"), " ").toString().trim()
}