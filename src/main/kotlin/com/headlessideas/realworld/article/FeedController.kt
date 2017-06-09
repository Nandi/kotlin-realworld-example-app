package com.headlessideas.realworld.article

import com.headlessideas.realworld.util.authentication.authenticate
import com.headlessideas.realworld.util.toJson


class FeedController {
    init {
        @Suppress("UNUSED_VARIABLE")
        spark.kotlin.get("/api/articles") {
            val tag: String? = request.queryParams("tag")
            val author: String? = request.queryParams("author")
            val favorited: String? = request.queryParams("favorited")
            val limit: Int? = request.queryParams("limit")?.toInt()
            val offset: Int? = request.queryParams("offset")?.toInt()

            listOf(com.headlessideas.realworld.article.Article()).toJson(mapOf("articlesCount" to 1))
        }

        @Suppress("UNUSED_VARIABLE")
        spark.kotlin.get("/api/articles/feed") {
            authenticate()

            val limit: Int? = request.queryParams("limit")?.toInt()
            val offset: Int? = request.queryParams("offset")?.toInt()

            listOf(com.headlessideas.realworld.article.Article()).toJson(mapOf("articlesCount" to 1))
        }
    }
}