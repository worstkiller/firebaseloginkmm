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
                getSignUpActiveView()
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
            
            Text("Create your \naccount")
                .fontWeight(.bold)
                .font(.title).multilineTextAlignment(.center)
                .padding([.top,.bottom])
            
            Image(Utils.DOGGO_IMAGE).resizable().frame(width: 120, height: 120, alignment: .center)
            
            Spacer()
            
            VStack {
                
                HStack {
                    TextField("Your Name", text: $name).padding(.all)
                }.background(RoundedRectangle(cornerRadius:30).foregroundColor(Color.white))
                    .padding([.trailing,. leading, .bottom]).shadow(radius: 4)
                
                HStack {
                    TextField("Email", text: $email).padding(.all)
                }.background(RoundedRectangle(cornerRadius:30).foregroundColor(Color.white)).padding([.trailing,. leading, .bottom]).shadow(radius: 4)
                
                HStack {
                    TextField("Password", text: $password).padding(.all)
                }.background(RoundedRectangle(cornerRadius:30).foregroundColor(Color.white)).padding([.trailing,. leading]).shadow(radius: 4)
                
            }.padding([.leading, .bottom, .trailing])
            
            Button(action: {
                let signUpModel = SignUpRequest(name: self.name.description, email: self.email.description, password: self.password.description)
                self.signUpViewModel.onSignUpClick(signUpModel)
            }){
                Text("Create your account")
                    .font(.subheadline)
                    .padding(.all).foregroundColor(Color.white)
            }.background(RoundedRectangle(cornerRadius:30)
                .foregroundColor(Color.init(hex: Utils.COLOR_ACCENT))).padding(.all).shadow(radius: 4)
            
            Spacer()
            Spacer()
            
            
        }
    }
    
}

struct SignUpView_Previews: PreviewProvider {
    static var previews: some View {
        SignUpView(signUpViewModel: SignUpViewModel())
    }
}
