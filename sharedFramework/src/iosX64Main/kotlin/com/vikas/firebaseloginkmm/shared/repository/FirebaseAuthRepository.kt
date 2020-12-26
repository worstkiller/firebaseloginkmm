package com.vikas.firebaseloginkmm.shared.repository

import cocoapods.FirebaseAuth.FIRAuth
import cocoapods.FirebaseAuth.FIRAuthDataResult
import com.vikas.firebaseloginkmm.shared.model.FirebaseResponseModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import platform.Foundation.NSError

@ExperimentalCoroutinesApi
actual class FirebaseAuthRepository actual constructor() {

    lateinit var firebaseAuthInstance: FIRAuth

    actual suspend fun signUpFirebase(
        name: String,
        email: String,
        password: String
    ): Flow<FirebaseResponseModel> {
        return callbackFlow {
            //starting the process with progress
            offer(FirebaseResponseModel.Loading(true))
            //now firebase sdk api call which is again a asynchronous call
            firebaseAuthInstance.createUserWithEmail(
                email,
                password
            ) { firAuthDataResult: FIRAuthDataResult?, nsError: NSError? ->
                if (firAuthDataResult != null) {
                    offer(
                        FirebaseResponseModel.Success(
                            firAuthDataResult.user.email ?: "",
                            firAuthDataResult.user.email ?: ""
                        )
                    )
                } else {
                    offer(FirebaseResponseModel.Failure(nsError?.description))
                }
            }
            awaitClose { cancel() }
        }
    }

    actual suspend fun getLoggedInUserData(): Flow<FirebaseResponseModel> {
        return flow {
            if (firebaseAuthInstance.currentUser != null) {
                val email = firebaseAuthInstance.currentUser!!.email ?: ""
                val name = firebaseAuthInstance.currentUser!!.displayName ?: ""
                emit(FirebaseResponseModel.Success(name, email))
            } else {
                emit(FirebaseResponseModel.Failure())
            }
        }
    }
}