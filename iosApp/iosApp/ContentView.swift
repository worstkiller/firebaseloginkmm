import SwiftUI

struct ContentView: View {
    
    private var signUpViewModel = SignUpViewModel()
    
    var body: some View {
        VStack {
            if signUpViewModel.isLoggedIn {
                HomeView()
            } else {
                SignUpView(signUpViewModel: signUpViewModel)
            }
        }.padding(.top, 4.0)
    }
}


struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
