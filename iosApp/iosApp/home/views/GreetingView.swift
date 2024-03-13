import SwiftUI
import shared

struct GreetingView: View {
	let user: String
	let greet = Greeting().greet()
	
    var body: some View {
        VStack {
        	Text(greet)
			
			Text( "Welcome user \(user)")
        }
    }
}

#Preview {
	GreetingView(user: "user@email.com")
}
