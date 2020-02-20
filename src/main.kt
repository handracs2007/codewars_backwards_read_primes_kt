package main

import kotlin.math.sqrt

val primeList = ArrayList<Long>()
val notPrimeList = ArrayList<Long>()

fun isPrime(number: Long): Boolean {
    if (primeList.contains(number))
        return true
    else if (notPrimeList.contains(number))
        return false

    for (factor in 2.rangeTo(sqrt(number.toDouble()).toInt())) {
        if (number % factor == 0L) {
            notPrimeList.add(number)
            return false
        }
    }

    if (number > 1) primeList.add(number)

    return number > 1
}

fun isBackwardsPrime(number: Long): Boolean {
    val reversedNumber = number.toString().reversed().toLong()

    return number > 10 && number != reversedNumber && isPrime(number) && isPrime(reversedNumber)
}

fun backwardsPrime(start: Long, end: Long): String {
    val builder = StringBuilder()

    for (number in start.rangeTo(end)) {
        if (isBackwardsPrime(number)) {
            builder.append("$number ")
        }
    }

    return builder.toString().trim()
}

fun main() {
    println(backwardsPrime(2, 100))
    println(backwardsPrime(9900, 10000))
}