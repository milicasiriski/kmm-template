import SwiftUI

struct LoginScreen: View {
	@EnvironmentObject var navigation: Navigation
	@StateObject var viewModel: LoginViewModel = LoginViewModel()
	
	var body: some View {
		VStack {
			Spacer()
				.frame(height: 30)
			
			Text("Login")
				.font(.largeTitle)
				.fontWeight(.medium)
				.multilineTextAlignment(.center)
				.padding(.horizontal, 50)
			
			if let error = viewModel.error {
				Spacer()
					.frame(height: 60)
				
				ErrorBanner(text: error)
					.padding(.horizontal, 30)
					.frame(maxWidth: .infinity)
			} else {
				Spacer()
					.frame(height: 80)
			}
			
			EmailTextField(text: $viewModel.email)
				.frame(maxWidth: .infinity)
			
			PasswordTextField(text: $viewModel.password)
				.frame(maxWidth: .infinity)
			
			ButtonWithProgressIndicator(
				label: "Login",
				loading: viewModel.loading,
				action: {
					viewModel.login(
						onSuccess: { navigation.home() },
						onError: { action in withAnimation { action() } })
				}
			)
			.padding(.top, 15)
			.padding(.horizontal, 30)
			.frame(maxWidth: .infinity)
			
			Spacer()
		}
	}
}
