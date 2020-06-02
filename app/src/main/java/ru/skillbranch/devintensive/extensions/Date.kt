package ru.skillbranch.devintensive.extensions

import java.util.*
import kotlin.math.abs
import java.text.SimpleDateFormat

const val SECOND = 1000L
const val MINUTE = 60* SECOND
const val HOUR = 60* MINUTE
const val DAY = 24* HOUR

fun Date.format(pattern: String="HH:mm:ss dd.MM.yy"):String{
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}
fun Date.add(value:Int, units: TimeUnits = TimeUnits.SECOND):Date{
    var time = this.time

    time +=when(units){
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }
    this.time = time
    return this
}

public fun Date.humanizeDiff(date:Date = Date()) : String{
    val status : String
    var diffData = date.time - this.time
    val negativeNumber = diffData < 0

    diffData = abs(diffData)
    val sec: Long = diffData / 1000
    val min = sec / 60
    val hours = min / 60
    val days = hours / 24

    if (negativeNumber){
        status = when{
            sec <= 1 -> "вот уже"
            sec <= 45 -> "через несколько секунд"
            sec <= 75 -> "через минуту"
            min <= 45 -> "через ${TimeUnits.MINUTE.plural(min.toInt())}"
            min <= 75 -> "через час"
            hours <= 22 -> "через ${TimeUnits.HOUR.plural(hours.toInt())}"
            hours <= 26 -> "через день"
            days <= 360 -> "через ${TimeUnits.DAY.plural(days.toInt())}"
            days > 360 -> "через год"
        else -> "более чем через год"
        }
    }else {
        status = when{
            sec <= 1 -> "только что"
            sec <= 45 -> "несколько секунд назад"
            sec <= 75 -> "минуту назад"
            min <= 45 -> "${TimeUnits.MINUTE.plural(min.toInt())} назад"
            min <= 75 -> "час назад"
            hours <= 22 -> "${TimeUnits.HOUR.plural(hours.toInt())} назад"
            hours <= 26 -> "день назад"
            days <= 360 -> "${TimeUnits.DAY.plural(days.toInt())} назад"
            days > 360 -> "более года назад"
            else -> "более года назад"
        }

    }
    return status
}

enum class TimeUnits{
    SECOND{
        override fun plural(value: Int):String{
            return when(value%10) {
                1 -> "$value секунду"
                2, 3, 4 -> "$value секунды"
                else -> "$value секунд"
            }
        }
    },
    MINUTE{
        override fun plural(value: Int):String{
            return when(value%10) {
                1 -> "$value минуту"
                2, 3, 4 -> "$value минуты"
                else -> "$value минут"
            }
        }

    },
    HOUR{
        override fun plural(value: Int):String{
            return when(value%10) {
                1 -> "$value час"
                2, 3, 4 -> "$value часа"
                else -> "$value часов"
            }
        }

    },
    DAY{
        override fun plural(value: Int):String{
            return when(value%10) {
                1 -> "$value день"
                2, 3, 4 -> "$value дня"
                else -> "$value дней"
            }
        }

    };
    abstract fun plural(value: Int):String
}


