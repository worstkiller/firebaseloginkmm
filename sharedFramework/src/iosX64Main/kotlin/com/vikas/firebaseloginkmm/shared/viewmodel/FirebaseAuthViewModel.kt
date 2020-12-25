package com.vikas.firebaseloginkmm.shared.viewmodel

import com.vikas.firebaseloginkmm.shared.model.FirebaseResponseModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import cocoapods.FirebaseAuth.*

actual class FirebaseAuthViewModel actual constructor() {

    lateinit var firebaseAuth: FirebaseAuth

    actual suspend fun signUpFirebase(
        name: String,
        email: String,
        password: String
    ): Flow<FirebaseResponseModel> {
        return flow { emit(FirebaseResponseModel.Success("", "")) }
    }

    actual suspend fun getLoggedInUserData(): Flow<FirebaseResponseModel> {
        return flow { emit(FirebaseResponseModel.Success("", "")) }
    }
}