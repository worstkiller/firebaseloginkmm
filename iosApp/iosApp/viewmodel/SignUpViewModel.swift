//
//  SignUpViewModel.swift
//  iosApp
//
//  Created by Vikas on 13/09/20.
//  Copyright © 2020 orgName. All rights reserved.
//

import Foundation
/**
 view model class for the signup screen
 */
class SignUpViewModel : ObservableObject{
    
    @Published var showLoader: Bool = false
    @Published var isLoggedIn: Bool = false
    
    init() {
        isLoggedIn = getLoggedIn()
    }
    
    func onSignUpClick(_ signUpModel: SignUpRequest) {
        //here make an api call to signup the user data in firebase
        //showLoader.toggle()
        //now call common code to signup using firebase
        print("Signup clicked \(signUpModel.email)")
        isLoggedIn.toggle()
    }
    
    /**
     call this method to get the signed up status
     */
    func getLoggedIn()->Bool{
        return false
    }
    
}
