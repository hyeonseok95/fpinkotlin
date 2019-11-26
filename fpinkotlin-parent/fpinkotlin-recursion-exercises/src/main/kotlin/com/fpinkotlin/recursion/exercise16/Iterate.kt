package com.fpinkotlin.recursion.exercise16


fun <T> iterate(seed: T, f: (T) -> T, n: Int): List<T> {
    tailrec fun iterate(currentSeed: T, currentIndex: Int, acc: MutableList<T>): List<T> =
            if (currentIndex == 0) {
                acc
            } else {
                iterate(f(currentSeed), currentIndex - 1, acc.apply { add(currentSeed) })
            }

    return iterate(seed, n, mutableListOf())
}