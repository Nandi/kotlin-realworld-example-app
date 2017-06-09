package com.headlessideas.realworld.profile

import com.headlessideas.realworld.util.authentication.authenticate
import com.headlessideas.realworld.util.toJson

class FollowController {
    init {
        spark.kotlin.post("/api/profiles/:username/follow") {
            authenticate()
            val username = request.params(":username")
            Profile(username, following = true).toJson()
        }

        spark.kotlin.delete("/api/profiles/:username/follow") {
            authenticate()
            val username = request.params(":username")
            Profile(username).toJson()
        }
    }
}