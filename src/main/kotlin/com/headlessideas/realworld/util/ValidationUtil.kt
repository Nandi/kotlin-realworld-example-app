package com.headlessideas.realworld.util

import kotlin.reflect.KProperty1

fun <M : Any> M.requiredFields(vararg properties: KProperty1<M, Any?>, message: String = "Some required fields are missing") {
    if (properties.any { it.get(this) == null || it.get(this).toString().isBlank() }) {
        throw ValidationException(message)
    }
}
