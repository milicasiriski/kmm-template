import Foundation
import SwiftUI

class Navigation: ObservableObject {
	@Published var paths: NavigationPath
	
	init() {
		let emptyStringArray: [String] = []
		paths = NavigationPath(emptyStringArray)
	}
	
	func login() {
		paths.append(Paths.login)
	}
	
	func home() {
		paths.append(Paths.home)
	}
}
