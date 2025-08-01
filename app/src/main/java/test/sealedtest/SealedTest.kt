package test.sealedtest

import okhttp3.Response
import java.lang.Exception

class SealedTest {
}

fun main() {
    val result: Result = Result.Loading(false)
    when(result) {
        is Result.Loading -> {

        }

        is Result.success -> {

        }

        is Result.Failure -> {

        }
    }
}

sealed class Result {
    data class success(val response : Response): Result()
    data class Failure(val exception: Exception): Result()
    data class Loading(var loading : Boolean) : Result()
}

