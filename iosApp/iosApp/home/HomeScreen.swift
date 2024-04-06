import SwiftUI

struct HomeScreen: View {
	@EnvironmentObject var navigation: Navigation
	@StateObject var viewModel: HomeViewModel = HomeViewModel()
	
    var body: some View {
		ScrollView {
			GreetingView(user: viewModel.user)
			
			LazyVStack {
				ForEach(viewModel.items, id: \.id) { item in
					NavigationLink(value: item) {
						ItemView(item: item)
							.padding(.horizontal, 30)
					}
				}
			}
		}
    }
}
