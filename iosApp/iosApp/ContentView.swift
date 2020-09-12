import SwiftUI
import shared

func greet() -> String {
    return Greeting().greeting()
}

struct ContentView: View {
    
    @State private var name: String = ""
    
    var body: some View {
        VStack {
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
                    TextField("Email", text: $name).padding(.all)
                    }.background(RoundedRectangle(cornerRadius:30).foregroundColor(Color.white)).padding([.trailing,. leading, .bottom]).shadow(radius: 4)
                           
                HStack {
                    TextField("Password", text: $name).padding(.all)
                }.background(RoundedRectangle(cornerRadius:30).foregroundColor(Color.white)).padding([.trailing,. leading]).shadow(radius: 4)
                
            }.padding([.leading, .bottom, .trailing])
            
            Button(action: {
                                          
                }){
                    Text("Create your account")
                .font(.subheadline)
                .padding(.all).background(RoundedRectangle(cornerRadius:30)
                .foregroundColor(Color.init(hex: Utils.COLOR_ACCENT)))
                        .foregroundColor(Color.white)
            }.padding(.all).shadow(radius: 4)

            Spacer()
            Spacer()
            
            
        }.background(Color.init(hex: Utils.WINDOW_COLOR))
    }
}


struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
