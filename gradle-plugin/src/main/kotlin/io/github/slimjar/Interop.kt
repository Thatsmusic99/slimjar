package io.github.slimjar // ktlint-disable filename

import groovy.lang.Closure

public inline fun Any.asGroovyClosure(default: String, crossinline func: (arg: String) -> String): (String) -> String =
    object : Closure<String>(this), (String) -> String, () -> String {
        fun doCall(arg: String) = func(arg)
        fun doCall() = doCall(default)
        override fun invoke(p1: String): String = doCall(p1)
        override fun invoke(): String = invoke(default)
    }
