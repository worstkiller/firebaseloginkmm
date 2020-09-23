package com.vikas.firebaseloginkmm.shared.model

/**
 * state model for the firebase signup operation
 */
sealed class FirebaseResponseModel {

    class Success(val name: String, val email: String)
    class Failure(error: String? = null)
    class Loading(isLoading: Boolean = false)

}