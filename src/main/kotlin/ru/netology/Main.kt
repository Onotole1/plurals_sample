package ru.netology

import com.ibm.icu.text.PluralRules
import java.util.*

fun main() {
    val locale = Locale("RU")
    val plurals = PluralRules.forLocale(locale)
    repeat(30) { catsCount ->
        val cats = getCats(catsCount, plurals)
        println(cats)
    }
}

private fun getCats(likes: Int, plurals: PluralRules): String {
    if (likes == 0) {
        return "Нет котиков ;("
    }

    val plural = plurals.select(likes.toDouble())
    return when (plural) {
        PluralRules.KEYWORD_ONE -> "%d котик"
        PluralRules.KEYWORD_FEW -> "%d котика"
        else -> "%d котиков"
    }.format(likes)
}