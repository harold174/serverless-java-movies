package com.movies.exceptions

import com.core.exceptions.MyException

class MovieAlreadyExistsException(code: Int = 400, message: String = "Movie Already Exists") : MyException(code, message)

class MovieNotExistsException(code: Int = 404, message: String = "Movie Doesn't Exists") : MyException(code, message)