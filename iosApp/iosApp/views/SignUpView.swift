//
//  SignUpView.swift
//  iosApp
//
//  Created by Vikas on 13/09/20.
//  Copyright © 2020 orgName. All rights reserved.
//

import SwiftUI

struct SignUpView: View {
    
    @State private var name: String = ""
    @State private var email: String = ""
    @State private var password: String = ""
    let signUpViewModel: SignUpViewModel
    
    var body: some View {
        VStack {
            if signUpViewModel.showLoader {
                ProgressView().frame(width: 64, height: 64, alignment: .center)
            } else {
                ScrollView {
                    getSignUpActiveView()
                }.background(Color(hex: Utils.WINDOW_COLOR))
                    .keyboardResponsive()
            }
        }
    }
    
    //view for entering email, name, password and clicking
    private func getSignUpActiveView()-> some View {
        VStack {
            
            Rectangle()
                .edgesIgnoringSafeArea(.top)
                .foregroundColor(Color.init(hex: Utils.COLOR_PRIMARY))
                .frame(height: 0)
            
            HStack {
                Image(Utils.BACK_IMAGE)
                    .resizable()
                    .renderingMode(.template)
                    .foregroundColor(Color.init(hex: Utils.COLOR_ACCENT))
                    .frame(width: 20, height: 20, alignment: .leading)
                Spacer()
                Text("Sign in").foregroundColor(Color(hex: Utils.COLOR_TEXT_SECONDARY))
            }.padding(.all)
            
            Text("Create your\naccount")
                .fontWeight(.bold)
                .font(.title)
                .multilineTextAlignment(.center)
                .frame(maxWidth: .infinity, alignment: .center)
            
            Spacer().frame(height: 35.0)
            
            Image(Utils.DOGGO_IMAGE).resizable().frame(width: 120, height: 120, alignment: .center)
            
            Spacer().frame(height: 70.0)
            
            VStack {
                
                TextField("Name", text: $name)
                    .padding(20)
                    .font(.headline)
                    .background(RoundedRectangle(cornerRadius: 30).foregroundColor(Color.white).shadow(radius: 4.0, x: 0.0, y: 4.0))
                
                Spacer().frame(height: 25.0)
                
                TextField("Email", text: $email)
                    .padding(20)
                    .font(.headline)
                    .background(RoundedRectangle(cornerRadius: 30).foregroundColor(Color.white).shadow(radius: 4.0, x: 0.0, y: 4.0))
                
                Spacer().frame(height: 25.0)
                
                TextField("Password", text: $password)
                    .padding(20)
                    .font(.headline)
                    .background(RoundedRectangle(cornerRadius: 30).foregroundColor(Color.white).shadow(radius: 4.0, x: 0.0, y: 4.0))
                
                Spacer().frame(height: 25.0)
                
            }.padding([.leading, .trailing], 30.0)
            
            Spacer().frame(height: 50.0)
            
            Button(action: {
                let signUpModel = SignUpRequest(name: self.name.description, email: self.email.description, password: self.password.description)
                self.signUpViewModel.onSignUpClick(signUpModel)
            }){
                Text("Create your account")
                    .padding(20)
                    .font(.headline)
                    .foregroundColor(Color.white)
                    .frame(maxWidth: .infinity)
                    .background(RoundedRectangle(cornerRadius: 30.0).foregroundColor(Color(hex: Utils.COLOR_ACCENT)).shadow(radius: 4.0, x: 0.0, y: 4.0))
                    .padding([.leading, .trailing], 30.0)
            }
            
            Spacer().frame(height: 25.0)
            
        }
    }
    
}

struct SignUpView_Previews: PreviewProvider {
    static var previews: some View {
        SignUpView(signUpViewModel: SignUpViewModel())
    }
}
