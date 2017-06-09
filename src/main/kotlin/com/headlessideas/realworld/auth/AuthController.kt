package com.headlessideas.realworld.auth

import com.headlessideas.realworld.user.User
import com.headlessideas.realworld.util.authentication.login
import com.headlessideas.realworld.util.authentication.register
import com.headlessideas.realworld.util.fromJson
import com.headlessideas.realworld.util.requiredFields
import com.headlessideas.realworld.util.toJson
import spark.kotlin.post

class AuthController {
    init {
        //Login route, requires user object with email and password
        post("/api/users/login") {
            val user = request.body().fromJson<User>()
            user.requiredFields(User::email, User::password, message = "Email and password required")
            login(user)
            user.toJson()
        }

        //Register route, requires user object with email, username and password
        post("/api/users") {
            val user = request.body().fromJson<User>()
            user.requiredFields(User::email, User::password, User::username, message = "Email, username and password required")
            register(user)
            user.toJson()
        }
    }
}