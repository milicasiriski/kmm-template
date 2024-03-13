import Foundation
import shared

@MainActor
class HomeViewModel: ObservableObject {
	private let localStorage: LocalStorage = Koin.instance.get(objCProtocol: LocalStorage.self)

	@Published private(set) var user: String = ""
	
	init() {
		// Swift null-check
		if let user = localStorage.getUser() {
			self.user = user
		}
		
		// Or
//		self.user = localStorage.getUser() ?? ""
	}
}
