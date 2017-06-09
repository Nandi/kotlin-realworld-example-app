package com.headlessideas.realworld.article

import com.fasterxml.jackson.annotation.JsonRootName
import com.headlessideas.realworld.util.annotation.PluralJsonRootName
import com.headlessideas.realworld.profile.Profile
import java.util.*

@JsonRootName("article")
@PluralJsonRootName("articles")
data class Article(val slug: String = "",
                   val title: String = "",
                   val description: String = "",
                   val body: String = "",
                   val tagList: List<String>? = listOf(),
                   val createdAt: Date? = Date(),
                   val updatedAt: Date? = Date(),
                   val favorited: Boolean? = false,
                   val favoritesCount: Int? = 0,
                   val author: Profile? = null)