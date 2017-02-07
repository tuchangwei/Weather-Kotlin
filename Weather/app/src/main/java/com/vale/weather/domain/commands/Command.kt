package com.vale.weather.domain.commands

/**
 * Created by vale on 07/02/2017.
 */
interface Command<T> {
    fun execute(): T
}