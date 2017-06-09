package com.headlessideas.realworld.user

import com.headlessideas.realworld.util.authentication.authenticate
import com.headlessideas.realworld.util.fromJson
import com.headlessideas.realworld.util.toJson
import spark.kotlin.get
import spark.kotlin.put

class UserController {
    init {
        get("/api/user") {
            authenticate()
            User("jake@jake.jake", username = "Jacob").toJson()
        }

        put("/api/user") {
            authenticate()
            val user = request.body().fromJson<User>()
            user.toJson()
        }
    }
}