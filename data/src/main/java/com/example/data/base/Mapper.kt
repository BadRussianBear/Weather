package com.example.data.base

abstract class Mapper<in I, out O> {

    abstract fun map(input: I): O

    open fun mapList(inputList: List<I>): List<O>{
        return inputList.map {
            map(it)
        }
    }
}