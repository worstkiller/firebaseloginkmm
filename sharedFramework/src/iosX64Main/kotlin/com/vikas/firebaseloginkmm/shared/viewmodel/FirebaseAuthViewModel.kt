package com.vikas.firebaseloginkmm.shared.viewmodel

import cocoapods.FirebaseCore.FIRApp
import platform.Foundation.version
import platform.UIKit.UIApplication

actual class FirebaseAuthViewModel actual constructor() {

    actual fun initFirebase() {
        FIRApp.configure()
        print("Firebase is initialized ${UIApplication.version()}")
    }
}