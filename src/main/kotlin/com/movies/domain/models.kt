package com.movies.domain

import com.core.domain.BaseModel

data class Person(var name: String, var surname: String) {
    constructor() : this("", "")
}

data class Movie(var title: String, var rate: Double, var language: String, var director: Person,
                 var cast: List<Person>, var code: String, override var id: Int?): BaseModel() {
    constructor(): this("", 0.0, "EN", Person(), listOf(Person()), "", -1)
}