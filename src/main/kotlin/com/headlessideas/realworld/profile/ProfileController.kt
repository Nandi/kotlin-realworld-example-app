package com.headlessideas.realworld.profile

import com.headlessideas.realworld.util.toJson
import spark.kotlin.get

class ProfileController {
    init {
        get("/api/profiles/:username") {
            val username = request.params(":username")
            Profile(username).toJson()
        }
    }
}