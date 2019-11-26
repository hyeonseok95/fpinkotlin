package com.fpinkotlin.recursion.exercise15


fun <T> List<T>.head(): T =
        if (this.isEmpty())
            throw IllegalArgumentException("head called on empty list")
        else
            this[0]

fun <T> List<T>.tail(): List<T> =
        if (this.isEmpty())
            throw IllegalArgumentException("tail called on empty list")
        else
            this.subList(1, this.size)

fun <T, U> foldLeft(list: List<T>, z: U, f: (U, T) -> U): U {
    tailrec fun foldLeft_(list: List<T>, acc: U, f: (U, T) -> U): U =
            if (list.isEmpty())
                acc
            else
                foldLeft_(list.tail(), f(acc, list.head()), f)
    return foldLeft_(list, z, f)
}

fun fibo(number: Int): String {
    tailrec fun fibo(index: Int, acc: String, previousValues: Pair<Int, Int>): String =
            when {
                number == index -> acc
                index == 0 -> fibo(index + 1, "0", Pair(1, 0))
                else -> {
                    val currentValue = previousValues.first + previousValues.second
                    fibo(index + 1, makeString(listOf(acc, currentValue), ","), Pair(previousValues.second, currentValue))
                }
            }
    return fibo(0, "", Pair(0, 0))
}

fun <T> makeString(list: List<T>, separator: String): String = foldLeft(list.tail(), list.head().toString()) { acc, item -> acc + separator + item.toString() }