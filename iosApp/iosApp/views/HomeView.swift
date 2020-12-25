//
//  HomeView.swift
//  iosApp
//
//  Created by Vikas on 13/09/20.
//  Copyright © 2020 orgName. All rights reserved.
//

import SwiftUI

/**
 home view to be shown after successful login
 */
struct HomeView: View {
    
    @State var name: String = "Luci"
    
    var body: some View {
        VStack {
            
            Rectangle()
                .edgesIgnoringSafeArea(.top)
                .foregroundColor(Color.init(hex: Utils.COLOR_PRIMARY))
                .frame(height: 0)
            
            HStack {
                Spacer()
            }
            Spacer()
            Image(Utils.DOGGO_IMAGE).resizable().frame(width: 120, height: 120, alignment: .center)
            Text("Welcone \(name)").font(.title).padding(.top)
            Spacer()
        }
    }
}

struct HomeView_Previews: PreviewProvider {
    static var previews: some View {
        HomeView()
    }
}
