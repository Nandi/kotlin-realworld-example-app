package com.headlessideas.realworld.comment

import com.fasterxml.jackson.annotation.JsonRootName
import com.headlessideas.realworld.util.annotation.PluralJsonRootName
import com.headlessideas.realworld.profile.Profile
import java.util.*

@JsonRootName("comment")
@PluralJsonRootName("comments")
data class Comment(val id: Int = 0,
                   val createdAt: Date? = Date(),
                   val updatedAt: Date? = Date(),
                   val body: String,
                   val author: Profile? = null)