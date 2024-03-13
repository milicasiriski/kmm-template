import SwiftUI

struct HomeScreen: View {
	@StateObject var viewModel: HomeViewModel = HomeViewModel()
	
    var body: some View {
		GreetingView(user: viewModel.user)
    }
}
