import SwiftUI
import shared

func greet() -> String {
    return Greeting().greeting()
}

struct ContentView: View {
    
    private var signUpViewModel = SignUpViewModel()
    
    var body: some View {
        VStack {
            if signUpViewModel.isLoggedIn {
                HomeView()
            } else {
                SignUpView(signUpViewModel: signUpViewModel)
            }
        }.background(Color.init(hex: Utils.WINDOW_COLOR))
    }
}


struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
