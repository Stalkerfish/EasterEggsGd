package com.alliwonka.dexapp

abstract class Item {
    val locus: Enum<*>? = null
    open val name: String? = locus?.name

    abstract fun useItem()
}