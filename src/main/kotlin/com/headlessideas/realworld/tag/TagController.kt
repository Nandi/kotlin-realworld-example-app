package com.headlessideas.realworld.tag

import com.headlessideas.realworld.util.toJson
import spark.kotlin.get

class TagController {
    init {
        get("/api/tags") {
            emptyMap<String, Any>().toJson(mapOf("tags" to listOf("reactjs", "angularjs")))
        }
    }
}