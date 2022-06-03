package com.example.presentation.base

abstract class Mapper<in I, out O> {

    abstract fun mapToView(input: I): O

    open fun mapListToView(list: List<I>) = list.map { mapToView(it) }
}