@file:Suppress("UNUSED_PARAMETER")

package com.headlessideas.realworld.util.authentication

import com.headlessideas.realworld.user.User
import com.headlessideas.realworld.util.AuthorizationException
import com.headlessideas.realworld.util.ValidationException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import spark.kotlin.RouteHandler
import java.util.*
import javax.naming.AuthenticationException

private val TOKEN_PREFIX = "Token "
private val HEADER_STRING = "Authorization"
private val EXPIRATION_TIME = 864_000_000
private val SECRET = "secret"


fun login(user: User) {
    if (!isValid(user)) {
        throw AuthorizationException("Username or password invalid")
    }

    user.token = getToken(user.email)
}

fun register(user: User) {
    if (userExists(user.email)) {
        throw AuthorizationException("Username already exists")
    }

    if (!createUser(user)) {
        throw AuthenticationException("Could not create user")
    }

    user.token = getToken(user.email)
}

fun getToken(email: String) = generateToken(email)

fun generateToken(token: String): String =
        Jwts.builder()
                .setSubject(token)
                .setExpiration(Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET).compact()

fun RouteHandler.authenticate() {
    val tokenHeader: String = request.headers(HEADER_STRING) ?: throw ValidationException("No token")

    val email = io.jsonwebtoken.Jwts.parser()
            .setSigningKey(SECRET)
            .parseClaimsJws(tokenHeader.replace(TOKEN_PREFIX, ""))
            .body
            .subject

    if (!userExists(email)) {
        throw ValidationException("Invalid token")
    }
}

//todo: implement
fun isValid(user: User): Boolean = true

//todo: implement
fun createUser(user: User): Boolean = true

//todo: implement
fun userExists(email: String): Boolean = true