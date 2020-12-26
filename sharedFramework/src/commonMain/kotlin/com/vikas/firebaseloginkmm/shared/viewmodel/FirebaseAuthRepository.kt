package com.vikas.firebaseloginkmm.shared.viewmodel

import com.vikas.firebaseloginkmm.shared.model.FirebaseResponseModel
import kotlinx.coroutines.flow.Flow

//common firebase view model for the signup, is expected to be implemented in
//the common ios and android modules respectively
expect class FirebaseAuthRepository() {

    /**
     * signup function for firebase
     */
    suspend fun signUpFirebase(
        name: String,
        email: String,
        password: String
    ): Flow<FirebaseResponseModel>

    //common function to get logged in user data
    suspend fun getLoggedInUserData(): Flow<FirebaseResponseModel>
}