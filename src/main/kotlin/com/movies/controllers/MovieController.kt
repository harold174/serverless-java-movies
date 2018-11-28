package com.movies.controllers

import com.core.controllers.Controller
import com.core.domain.Request
import com.core.domain.User
import com.core.service.Service
import com.movies.domain.Movie
import com.movies.services.MovieService

class MovieController: Controller<Movie> {

    fun movie(request: Request?) : Any {
        val service: Service<Movie, User> = MovieService()
        return defaultRouting(Movie::class.java, request!!, service)
    }
}