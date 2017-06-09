package com.headlessideas.realworld.util

import com.fasterxml.jackson.annotation.JsonRootName
import com.fasterxml.jackson.module.kotlin.readValue
import com.headlessideas.realworld.JsonMapper.objectMapper
import com.headlessideas.realworld.util.annotation.PluralJsonRootName
import kotlin.reflect.full.findAnnotation

inline fun <reified M : Any> String.fromJson(): M = objectMapper.readValue<M>(this)

inline fun <reified M : Any> Collection<M>.toJson(additionalValues: Map<String, Any> = emptyMap()): String {
    val name = M::class.findAnnotation<PluralJsonRootName>()?.plural ?: M::class.simpleName ?: ""
    return objectMapper.writeValueAsString(constructResponse(name, this, additionalValues))
}

fun <M : Any> M.toJson(additionalValues: Map<String, Any> = emptyMap()): String {
    val name = this::class.findAnnotation<JsonRootName>()?.value ?: this::class.simpleName ?: ""
    return objectMapper.writeValueAsString(constructResponse(name, this, additionalValues))
}

fun constructResponse(name: String, value: Any, additionalValues: Map<String, Any>): MutableMap<String, Any> {
    val response = mutableMapOf(name to value)
    response.putAll(additionalValues)
    return response
}
