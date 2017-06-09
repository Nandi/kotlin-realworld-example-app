package com.headlessideas.realworld.comment

import com.headlessideas.realworld.profile.Profile
import com.headlessideas.realworld.util.fromJson
import com.headlessideas.realworld.util.requiredFields
import com.headlessideas.realworld.util.toJson
import spark.kotlin.delete
import spark.kotlin.get
import spark.kotlin.post
import java.util.*

@Suppress("UNUSED_VARIABLE")
class CommentsController {
    init {
        get("/api/articles/:slug/comments") {
            val slug = request.params(":slug")
            listOf(Comment(1, Date(), Date(), "", Profile("JackJack"))).toJson()
        }

        post("/api/articles/:slug/comments") {
            val slug = request.params(":slug")
            val comment = request.body().fromJson<Comment>()
            comment.requiredFields(Comment::body, message = "Body cannot be empty")
            comment.toJson()
        }

        delete("/api/articles/:slug/comments/:id") {
            val slug = request.params(":slug")
            val id = request.params(":id")
            "" //empty response
        }
    }
}