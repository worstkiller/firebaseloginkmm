package com.vikas.firebaseloginkmm.shared.viewmodel

import com.vikas.firebaseloginkmm.shared.model.FirebaseResponseModel
import kotlinx.coroutines.flow.Flow
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow

@ExperimentalCoroutinesApi
actual class FirebaseAuthRepository actual constructor() {

    private val firebaseAuthInstance: FirebaseAuth = FirebaseAuth.getInstance()

    actual suspend fun signUpFirebase(
        name: String,
        email: String,
        password: String
    ): Flow<FirebaseResponseModel> {
        return callbackFlow {
            //starting the process with progress
            offer(FirebaseResponseModel.Loading(true))
            //now firebase sdk api call which is again a asynchronous call
            firebaseAuthInstance.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        offer(FirebaseResponseModel.Success(name, it.result?.user?.email ?: ""))
                    } else {
                        offer(FirebaseResponseModel.Failure(it.exception?.message ?: ""))
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