package com.fpinkotlin.recursion.exercise10


fun <T> unfold(seed: T, f: (T) -> T, p: (T) -> Boolean): List<T> {
    var indexSeed = seed
    while(!p(indexSeed)) indexSeed = f(indexSeed)

    val mutableList = mutableListOf<T>()
    while(p(indexSeed)){
        mutableList.add(indexSeed)
        indexSeed = f(indexSeed)
    }

    return mutableList
}

