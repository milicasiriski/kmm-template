import Foundation

class Navigation: ObservableObject {
	@Published var paths: [String]
	
	init() {
		paths = []
	}
	
	func login() {
		paths.append(Paths.login)
	}
	
	func home() {
		paths.append(Paths.home)
	}
}
