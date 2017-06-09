package com.headlessideas.realworld.user

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonRootName
import com.headlessideas.realworld.util.annotation.PluralJsonRootName

@JsonRootName("user")
@PluralJsonRootName("users")
@JsonIgnoreProperties(value = "password", allowSetters = true)
data class User(var email: String = "",
                var username: String? = null,
                var password: String? = null,
                var bio: String? = null,
                var image: String? = null,
                var token: String? = null)