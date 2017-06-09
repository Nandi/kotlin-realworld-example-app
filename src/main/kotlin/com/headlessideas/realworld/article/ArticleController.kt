package com.headlessideas.realworld.article

import com.headlessideas.realworld.util.authentication.authenticate
import com.headlessideas.realworld.util.fromJson
import com.headlessideas.realworld.util.toJson
import spark.kotlin.delete
import spark.kotlin.get
import spark.kotlin.post
import spark.kotlin.put

class ArticleController {
    init {
        get("/api/articles/:slug") {
            val slug = request.params(":slug")
            Article(slug).toJson()
        }

        post("/api/articles") {
            authenticate()
            val article = request.body().fromJson<Article>()
            article.toJson()
        }

        @Suppress("UNUSED_VARIABLE")
        put("/api/articles/:slug") {
            authenticate()
            val slug = request.params(":slug")
            val article = request.body().fromJson<Article>()
            article.toJson()
        }

        delete("/api/articles/:slug") {
            authenticate()
            val slug = request.params(":slug")
            Article(slug).toJson()
        }
    }
}