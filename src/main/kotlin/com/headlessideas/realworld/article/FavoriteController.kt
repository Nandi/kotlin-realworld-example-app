package com.headlessideas.realworld.article

import com.headlessideas.realworld.util.authentication.authenticate
import com.headlessideas.realworld.util.toJson

class FavoriteController {
    init {
        spark.kotlin.post("/api/articles/:slug/favorite") {
            authenticate()
            val slug = request.params("slug")
            Article(slug, favorited = true, favoritesCount = 1).toJson()
        }

        spark.kotlin.delete("/api/articles/:slug/favorite") {
            authenticate()
            val slug = request.params("slug")
            Article(slug, favorited = false, favoritesCount = 1).toJson()
        }
    }
}