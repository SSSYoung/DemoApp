package test

import kotlinx.coroutines.suspendCancellableCoroutine

class SuspendCancellableCoroutineTest {
    private suspend fun fetchUser():User = suspendCancellableCoroutine {
            cancellableContinuation ->
        fetchUserFromNetwork(object : Callback {
            override fun onSuccess(user: User) {

            }

            override fun onFailure(exception: Exception) {
            }
        })

    }

    private fun fetchUserFromNetwork(callback: Callback) {
        Thread {
            Thread.sleep(3_000)

            // Invokes onSuccess() with user data.
            callback.onSuccess(User())
        }.start()
    }
}

interface Callback {
    fun onSuccess(user: User)
    fun onFailure(exception: Exception)
}

class User
