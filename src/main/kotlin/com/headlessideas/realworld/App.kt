package com.headlessideas.realworld

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.headlessideas.realworld.article.ArticleController
import com.headlessideas.realworld.article.FavoriteController
import com.headlessideas.realworld.article.FeedController
import com.headlessideas.realworld.auth.AuthController
import com.headlessideas.realworld.comment.CommentsController
import com.headlessideas.realworld.profile.FollowController
import com.headlessideas.realworld.profile.ProfileController
import com.headlessideas.realworld.tag.TagController
import com.headlessideas.realworld.user.UserController
import spark.kotlin.after
import spark.kotlin.port
import java.text.SimpleDateFormat


object JsonMapper {
    val objectMapper: ObjectMapper = ObjectMapper()
            .registerModule(KotlinModule())
            .setDateFormat(SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"))
            .configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true)
}

fun main(args: Array<String>) {
    port(8080)
    AuthController()
    UserController()
    FeedController()
    ArticleController()
    FavoriteController()
    TagController()
    ProfileController()
    FollowController()
    CommentsController()

    after {
        response.type("application/json")
    }

    /* todo: wait for exception handling in spark-kotlin
    exception(ValidationException::class) {
        status(422)
        mapOf(Pair("errors", mapOf(Pair("body", listOf(exception.message ?: "Validation error"))))).toJson()
    }
    */
}



