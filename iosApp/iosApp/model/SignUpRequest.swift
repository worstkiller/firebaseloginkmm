//
//  SignUpRequest.swift
//  iosApp
//
//  Created by Vikas on 13/09/20.
//  Copyright © 2020 orgName. All rights reserved.
//

import Foundation

//model for sending the signup request, sending data like email, password, name
struct SignUpRequest {
    
    let name: String
    let email: String
    let password: String
    
}
