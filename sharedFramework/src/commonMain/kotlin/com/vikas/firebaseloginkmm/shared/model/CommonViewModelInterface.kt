package com.vikas.firebaseloginkmm.shared.model

import kotlinx.coroutines.flow.Flow

/**
 * view model interface for common functionalities between the android and ios versions of viewmodel
 */
interface CommonViewModelInterface {

    /**
     * signup function to be implemented
     */
    suspend fun signUpFirebase(
        name: String,
        email: String,
        password: String
    ): Flow<FirebaseResponseModel>

    //common function to get logged in user data
    suspend fun getLoggedInUserData(): Flow<FirebaseResponseModel>

}