package com.vikas.firebaseloginkmm.shared.model

/**
 * state model for the firebase signup operation
 */
sealed class FirebaseResponseModel {

    class Success(val name: String, val email: String) : FirebaseResponseModel()
    class Failure(error: String? = null) : FirebaseResponseModel()
    class Loading(isLoading: Boolean = false) : FirebaseResponseModel()

}