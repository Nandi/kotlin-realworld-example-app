package com.headlessideas.realworld.profile

import com.fasterxml.jackson.annotation.JsonRootName
import com.headlessideas.realworld.util.annotation.PluralJsonRootName

@JsonRootName("profile")
@PluralJsonRootName("profiles")
data class Profile(val username: String,
                   val bio: String = "",
                   val image: String = "",
                   val following: Boolean = false)