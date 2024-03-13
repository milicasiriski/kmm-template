import Foundation
import shared

@MainActor
class LoginViewModel: ObservableObject {
	private let login: LoginUseCase = Koin.instance.get()
	
	@Published var email: String = ""
	@Published var password: String = ""
	@Published private(set) var error: String? = nil
	@Published private(set) var loading: Bool = false
	
	func login(onSuccess: @escaping () -> Void, onError: @escaping (_ action: () -> Void) -> Void) {
		loading = true
		if (email.trimmingCharacters(in: .whitespaces).isEmpty || password.trimmingCharacters(in: .whitespaces).isEmpty) {
			onError { error = "Email and password cannot be empty" }
			loading = false
			return
		}
		
		Task {
			let result = try await login.invoke(email: email, password: password)
			
			if result.isRight {
				onError { error = nil }
				onSuccess()
			} else {
				onError { error = "Invalid credentials" }
			}
			
			loading = false
		}
	}
}
